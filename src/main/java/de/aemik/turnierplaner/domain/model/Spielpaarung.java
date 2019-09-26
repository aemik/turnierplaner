package de.aemik.turnierplaner.domain.model;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class Spielpaarung {

	private String id;
	private Spieler spieler1;
	private Spieler spieler2;
	private Spieler gewinner;

	private Spielpaarung(String id, Spieler spieler1, Spieler spieler2) {
		Objects.requireNonNull(spieler1, "spieler1 is required");
		Objects.requireNonNull(spieler2, "spieler2 is required");

		this.spieler1 = spieler1;
		this.spieler2 = spieler2;

		if (id == null) {
			this.id = UUID.randomUUID().toString();
		} else {
			this.id = id;
		}
	}

	public static Spielpaarung create(Spieler spieler1, Spieler spieler2) {
		return new Spielpaarung(null, spieler1, spieler2);
	}

	public static Spielpaarung restore(String id, Spieler spieler1, Spieler spieler2) {
		return new Spielpaarung(id, spieler1, spieler2);
	}

	public String getId() {
		return id;
	}

	public Spieler getSpieler1() {
		return spieler1;
	}

	public Spieler getSpieler2() {
		return spieler2;
	}

	public void setGewinner(Spieler spieler) {
		if (!spieler1.equals(spieler) && !spieler2.equals(spieler)) {
			throw new IllegalArgumentException("not valid spieler for this spielpaarung!");
		}
		this.gewinner = spieler;
	}

	public Optional<Spieler> getGewinner() {
		return Optional.ofNullable(gewinner);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Spielpaarung [id=");
		builder.append(id);
		builder.append(", spieler1=");
		builder.append(spieler1);
		builder.append(", spieler2=");
		builder.append(spieler2);
		builder.append(", gewinner=");
		builder.append(gewinner);
		builder.append("]");
		return builder.toString();
	}
	
	
}
