package de.theonlyal.payara.entitylistenerbug;

import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditEntityListener {

	@Inject
	private AuditEntityListenerServiceBean service;

	@PrePersist
	@PreUpdate
	public void prePersist(final AuditEntity audit) {
		if (service == null) {
			System.out.println("Could not inject AuditEntityListenerServiceBean!");
		} else {
			audit.setLastChange(service.getLastChange());

		}
	}
}