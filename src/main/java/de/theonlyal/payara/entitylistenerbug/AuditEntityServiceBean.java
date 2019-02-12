package de.theonlyal.payara.entitylistenerbug;

import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Singleton
public class AuditEntityServiceBean {

	@PersistenceContext(unitName = "entitylistener-pu")
	private EntityManager em;

	@PostConstruct
	public void postConstruct() {
		final AuditEntity entity = new AuditEntity(UUID.randomUUID().toString());
		em.persist(entity);

		System.out.println("LastChange: " + entity.getLastChange());
	}
}