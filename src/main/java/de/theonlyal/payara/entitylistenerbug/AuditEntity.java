package de.theonlyal.payara.entitylistenerbug;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audit")
@EntityListeners(AuditEntityListener.class)
public class AuditEntity {

	@Id
	private String id;

	@Column(name = "simple_attribute")
	@Convert(converter = NopAttributeConverter.class)
	private String simpleAttribute;

	@Column(name = "last_change")
	private LocalDateTime lastChange;

	protected AuditEntity() {
	}

	public AuditEntity(final String id) {
		this.id = id;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final AuditEntity other = (AuditEntity) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getLastChange() {
		return lastChange;
	}

	public String getSimpleAttribute() {
		return simpleAttribute;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (id == null ? 0 : id.hashCode());
		return result;
	}

	public void setLastChange(final LocalDateTime lastChange) {
		this.lastChange = lastChange;
	}

	public void setSimpleAttribute(final String simpleAttribute) {
		this.simpleAttribute = simpleAttribute;
	}
}