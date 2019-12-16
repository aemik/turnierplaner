package de.aemik.turnierplaner.domain;

import java.util.UUID;

/**
 * 
 * abstract domain object to handle an unique id for each domain
 *
 */
public abstract class DomainObject {

	protected String id;

	public DomainObject() {
		this(null);
	}

	public DomainObject(String id) {
		if (id == null) {
			this.id = UUID.randomUUID().toString();
		} else {
			this.id = id;
		}
	}

	public String getId() {
		return id;
	}

}