package de.aemik.turnierplaner.domain.service;

import java.util.Collection;

import de.aemik.turnierplaner.domain.model.Verein;

public interface VereinRepository {

	public void save(Verein verein);
	
	public Collection<Verein> findAll();
}
