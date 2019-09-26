package de.aemik.turnierplaner.adapter.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import de.aemik.turnierplaner.domain.model.Verein;
import de.aemik.turnierplaner.domain.service.VereinRepository;

public class VereinRepositoryMemImpl implements VereinRepository {

	private Map<String, Verein> map = new HashMap<>();
	
	@Override
	public void save(Verein verein) {
		if (map.putIfAbsent(verein.getNummer(), verein) != null) {
			throw new IllegalArgumentException(verein.getNummer() + " still exists!");
		}
	}

	@Override
	public Collection<Verein> findAll() {
		return map.values();
	}
	
	

}
