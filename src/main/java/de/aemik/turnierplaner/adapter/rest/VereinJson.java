package de.aemik.turnierplaner.adapter.rest;

import de.aemik.turnierplaner.domain.model.Verein;

public class VereinJson {

	public String nummer;
	public String name;
	
	public static VereinJson of(Verein verein) {
		VereinJson vereinJson = new VereinJson();
		vereinJson.nummer = verein.getNummer().value();
		vereinJson.name = verein.getName();
		return vereinJson;
	}
	
}
