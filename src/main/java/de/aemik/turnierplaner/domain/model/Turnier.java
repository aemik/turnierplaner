package de.aemik.turnierplaner.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Turnier {

	private String id;
	private LocalDate datum;
	private Verein veranstalter;
	private Spielsystem spielsystem;

	private List<Spieler> gemeldeteSpieler;
	private List<Spielpaarung> spielpaarungen;

	private Turnier(String id, LocalDate datum, Verein veranstalter, Spielsystem spielsystem, List<Spieler> gemeldeteSpieler,
			List<Spielpaarung> spielpaarungen) {
		Objects.requireNonNull(datum, "datum is required");
		Objects.requireNonNull(veranstalter, "veranstalter is required");
		Objects.requireNonNull(spielsystem, "spielsystem is required");

		this.datum = datum;
		this.veranstalter = veranstalter;
		this.spielsystem = spielsystem;

		if (gemeldeteSpieler != null) {
			this.gemeldeteSpieler = gemeldeteSpieler;
		} else {
			this.gemeldeteSpieler = new ArrayList<>();
		}

		if (spielpaarungen != null) {
			this.spielpaarungen = spielpaarungen;
		} else {
			this.spielpaarungen = new ArrayList<>();
		}

		if (id == null) {
			this.id = UUID.randomUUID().toString();
		} else {
			this.id = id;
		}
	}

	public static Turnier create(LocalDate datum, Verein veranstalter, Spielsystem spielsystem) {
		return new Turnier(null, datum, veranstalter, spielsystem, new ArrayList<Spieler>(), new ArrayList<Spielpaarung>());
	}

	public static Turnier restore(String id, LocalDate datum, Verein veranstalter, Spielsystem spielsystem, List<Spieler> gemeldeteSpieler,
			List<Spielpaarung> spielpaarungen) {
		return new Turnier(id, datum, veranstalter, spielsystem, gemeldeteSpieler, spielpaarungen);
	}

	public void meldeAn(Spieler spieler) {
		Objects.requireNonNull(spieler, "spieler is required");
		gemeldeteSpieler.add(spieler);
	}

	public void spielpaarungenErstellen() {
		this.spielpaarungen.clear();
		this.spielpaarungen = spielsystem.erstelleSpielpaarungenFuer(gemeldeteSpieler);
	}

	public String getId() {
		return id;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public Verein getVeranstalter() {
		return veranstalter;
	}

	public List<Spieler> getGemeldeteSpieler() {
		return gemeldeteSpieler;
	}

	public List<Spielpaarung> getSpielpaarungen() {
		return spielpaarungen;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Turnier [id=");
		builder.append(id);
		builder.append(", datum=");
		builder.append(datum);
		builder.append(", veranstalter=");
		builder.append(veranstalter);
		builder.append(", spielsystem=");
		builder.append(spielsystem);
		builder.append(", gemeldeteSpieler=");
		builder.append(gemeldeteSpieler);
		builder.append(", spielpaarungen=");
		builder.append(spielpaarungen);
		builder.append("]");
		return builder.toString();
	}

}
