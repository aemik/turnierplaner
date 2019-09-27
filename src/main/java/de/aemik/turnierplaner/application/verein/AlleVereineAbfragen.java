package de.aemik.turnierplaner.application.verein;

import java.util.ArrayList;
import java.util.List;

import de.aemik.turnierplaner.domain.model.Verein;
import de.aemik.turnierplaner.domain.service.VereinRepository;

public class AlleVereineAbfragen {

	private VereinRepository vereinRepository;

	public AlleVereineAbfragen(VereinRepository vereinRepository) {
		this.vereinRepository = vereinRepository;
	}

	public List<Verein> get() {
		List<Verein> collection = new ArrayList<>();
		vereinRepository.findAll().forEach(collection::add);
		return collection;
	}

}
