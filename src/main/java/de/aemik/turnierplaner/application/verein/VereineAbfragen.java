package de.aemik.turnierplaner.application.verein;

import java.util.ArrayList;
import java.util.List;

import de.aemik.turnierplaner.domain.model.Verein;
import de.aemik.turnierplaner.domain.service.VereinRepository;

public class VereineAbfragen {

	private VereinRepository vereinRepository;

	public VereineAbfragen(VereinRepository vereinRepository) {
		this.vereinRepository = vereinRepository;
	}

	public List<Verein> getAll() {
		List<Verein> collection = new ArrayList<>();
		vereinRepository.findAll().forEach(collection::add);
		return collection;
	}

}
