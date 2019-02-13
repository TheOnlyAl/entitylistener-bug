package de.theonlyal.payara.entitylistenerbug;

import java.util.UUID;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class AuditEntityServiceBean {

	@PersistenceContext(unitName = "entitylistener-pu")
	private EntityManager em;

	public String persistEntity() {
		final AuditEntity entity = new AuditEntity(UUID.randomUUID().toString());
		em.persist(entity);

		return "LastChange: " + entity.getLastChange();
	}
}