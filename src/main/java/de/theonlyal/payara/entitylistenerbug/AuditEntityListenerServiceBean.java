package de.theonlyal.payara.entitylistenerbug;

import java.time.LocalDateTime;

import javax.ejb.Stateless;

@Stateless
public class AuditEntityListenerServiceBean {

	public LocalDateTime getLastChange() {
		return LocalDateTime.now();
	}
}
