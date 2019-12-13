package de.aemik.turnierplaner.domain.model;

import java.util.Objects;
import java.util.UUID;

/**
 * 
 * @category domain object
 * 
 */
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

	public static Spieler of(String vorname, String nachname, Jahrgang jahrgang, Verein verein) {
		return new Spieler(null, vorname, nachname, jahrgang, verein);
	}

	public static Spieler restore(String id, String vorname, String nachname, Jahrgang jahrgang, Verein verein) {
		return new Spieler(id, vorname, nachname, jahrgang, verein);
	}

	public String getId() {
		return id;
	}

	public String getFullname() {
		return vorname + " " + nachname;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jahrgang == null) ? 0 : jahrgang.hashCode());
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((verein == null) ? 0 : verein.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spieler other = (Spieler) obj;
		if (jahrgang == null) {
			if (other.jahrgang != null)
				return false;
		} else if (!jahrgang.equals(other.jahrgang))
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (verein == null) {
			if (other.verein != null)
				return false;
		} else if (!verein.equals(other.verein))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}

}
