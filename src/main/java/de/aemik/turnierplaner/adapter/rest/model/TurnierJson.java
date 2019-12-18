package de.aemik.turnierplaner.adapter.rest.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import de.aemik.turnierplaner.domain.model.Turnier;

public class TurnierJson {

	public String id;
	public String datum;
	public Set<String> gemeldeteSpieler = new HashSet<>();
	public Set<String> spielpaarungen = new HashSet<>();

	public static TurnierJson of(Turnier turnier) {
		TurnierJson turnierJson = new TurnierJson();
		
		turnierJson.id = turnier.getId();
		turnierJson.datum = turnier.getDatum().toString();
		turnierJson.gemeldeteSpieler = turnier.getGemeldeteSpieler().stream().map(s -> s.toString()).collect(Collectors.toSet());
		turnierJson.spielpaarungen  = turnier.getSpielpaarungen().stream().map(s -> s.toString()).collect(Collectors.toSet());
		
		return turnierJson;
	}

}
