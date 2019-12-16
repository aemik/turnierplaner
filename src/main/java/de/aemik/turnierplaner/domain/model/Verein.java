package de.aemik.turnierplaner.domain.model;

import java.util.Objects;

import de.aemik.turnierplaner.domain.DomainObject;

/**
 * 
 * @category domain object
 * 
 */
public class Verein extends DomainObject {

	private Vereinsnummer nummer;
	private String name;

	private Verein(String id, Vereinsnummer nummer, String name) {
		super(id);
		
		Objects.requireNonNull(nummer, "nummer is required");
		Objects.requireNonNull(name, "name is required");

		this.nummer = nummer;
		this.name = name;
	}

	public static Verein of(Vereinsnummer nummer, String name) {
		return new Verein(null, nummer, name);
	}

	public static Verein of(String id, Vereinsnummer nummer, String name) {
		return new Verein(id, nummer, name);
	}
	
	public Vereinsnummer getNummer() {
		return nummer;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Verein [nummer=").append(nummer).append(", name=").append(name).append("]");
		return builder.toString();
	}

}
