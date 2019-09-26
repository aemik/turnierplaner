package de.aemik.turnierplaner.domain.model;

import java.util.Objects;

public class Verein {

	private String nummer;
	private String name;
	
	private Verein(String nummer, String name) {
		Objects.requireNonNull(nummer, "nummer is required");
		Objects.requireNonNull(name, "name is required");
		
		this.nummer = nummer;
		this.name = name;
	}
	
	public static Verein of(String nummer, String name) {
		return new Verein(nummer, name);
	}

	public String getNummer() {
		return nummer;
	}

	public String getName() {
		return name;
	}
	
}
