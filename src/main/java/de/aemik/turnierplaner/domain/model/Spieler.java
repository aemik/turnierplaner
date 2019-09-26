package de.aemik.turnierplaner.domain.model;

import java.util.Objects;
import java.util.UUID;

public class Spieler {

	private String id;
	private String vorname;
	private String nachname;
	private Jahrgang jahrgang;
	private Verein verein;
	
	private Spieler(String id, String vorname, String nachname, Jahrgang jahrgang, Verein verein) {
		Objects.requireNonNull(vorname, "vorname is required");
		Objects.requireNonNull(nachname, "nachname is required");
		Objects.requireNonNull(jahrgang, "jahrgang is required");
		Objects.requireNonNull(verein, "verein is required");
		
		this.vorname = vorname;
		this.nachname = nachname;
		this.verein = verein;
		this.jahrgang = jahrgang;
		
		if (id == null) {
			this.id = UUID.randomUUID().toString();
		} else {
			this.id = id;
		}
	}
	
	public static Spieler create(String vorname, String nachname, Jahrgang jahrgang, Verein verein) {
		return new Spieler(null, vorname, nachname, jahrgang, verein);
	}
	
	public static Spieler restore(String id, String vorname, String nachname, Jahrgang jahrgang, Verein verein) {
		return new Spieler(id, vorname, nachname, jahrgang, verein);
	}

	public String getId() {
		return id;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}
	
	public Jahrgang getJahrgang() {
		return jahrgang;
	}

	public Verein getVerein() {
		return verein;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Spieler [id=");
		builder.append(id);
		builder.append(", vorname=");
		builder.append(vorname);
		builder.append(", nachname=");
		builder.append(nachname);
		builder.append(", jahrgang=");
		builder.append(jahrgang);
		builder.append(", verein=");
		builder.append(verein);
		builder.append("]");
		return builder.toString();
	}
	
	
}
