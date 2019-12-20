package de.aemik.turnierplaner.domain.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import de.aemik.turnierplaner.domain.DomainObject;

/**
 * 
 * @category domain object
 * 
 */
public class Turnier extends DomainObject {

	private LocalDate datum;
	private Verein veranstalter;
	private Spielsystem spielsystem;

	private Set<Spieler> gemeldeteSpieler;
	private Set<Spielpaarung> spielpaarungen;

	private Turnier(String id, LocalDate datum, Verein veranstalter, Spielsystem spielsystem, Set<Spieler> gemeldeteSpieler,
			Set<Spielpaarung> spielpaarungen) {
		super(id);
		
		Objects.requireNonNull(datum, "datum is required");
		Objects.requireNonNull(veranstalter, "veranstalter is required");
		Objects.requireNonNull(spielsystem, "spielsystem is required");

		this.datum = datum;
		this.veranstalter = veranstalter;
		this.spielsystem = spielsystem;

		if (gemeldeteSpieler != null) {
			this.gemeldeteSpieler = gemeldeteSpieler;
		} else {
			this.gemeldeteSpieler = new HashSet<>();
		}

		if (spielpaarungen != null) {
			this.spielpaarungen = spielpaarungen;
		} else {
			this.spielpaarungen = new HashSet<>();
		}
	}

	public static Turnier create(LocalDate datum, Verein veranstalter, Spielsystem spielsystem) {
		return new Turnier(null, datum, veranstalter, spielsystem, new HashSet<Spieler>(), new HashSet<Spielpaarung>());
	}

	public static Turnier restore(String id, LocalDate datum, Verein veranstalter, Spielsystem spielsystem, Set<Spieler> gemeldeteSpieler,
			Set<Spielpaarung> spielpaarungen) {
		return new Turnier(id, datum, veranstalter, spielsystem, gemeldeteSpieler, spielpaarungen);
	}

	public void meldeAn(Spieler spieler) {
		Objects.requireNonNull(spieler, "spieler is required");
		if (!spielpaarungen.isEmpty()) {
			throw new IllegalArgumentException("Es können keine Spieler mehr angemeldet werden. Die Spielpaarungen wurden bereits erstellt.");
		}
		gemeldeteSpieler.add(spieler);
	}

	public void spielpaarungenErstellen() {
		this.spielpaarungen.clear();
		this.spielpaarungen = spielsystem.erstelleSpielpaarungenFuer(gemeldeteSpieler);
	}
	
	public Map<Spieler, Integer> getSpielerGewinne() {
		Map<Spieler, Integer> spielerGewinneMap = new HashMap<>();
		for (Spieler spieler : gemeldeteSpieler) {
			spielerGewinneMap.put(spieler, 0);
		}
		for (Spielpaarung spielpaarung : spielpaarungen) {
			Optional<Spieler> gewinnerOptional = spielpaarung.getGewinner();
			if (gewinnerOptional.isPresent()) {
				int siege = spielerGewinneMap.get(gewinnerOptional.get()).intValue();
				siege = siege + 1;
				spielerGewinneMap.put(gewinnerOptional.get(), siege);
			}
		}
		return spielerGewinneMap;
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

	public Set<Spieler> getGemeldeteSpieler() {
		return gemeldeteSpieler;
	}

	public Set<Spielpaarung> getSpielpaarungen() {
		return spielpaarungen;
	}
	
	public Optional<Spielpaarung> getSpielpaarungById(String id) {
		return spielpaarungen.stream().filter(s -> s.getId().equals(id)).findFirst();
	}
	
	public Optional<Spieler> getGemeldetenSpielerById(String id) {
		return gemeldeteSpieler.stream().filter(s -> s.getId().equals(id)).findFirst();
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
