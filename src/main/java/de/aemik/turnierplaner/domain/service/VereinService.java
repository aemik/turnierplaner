package de.aemik.turnierplaner.domain.service;

import java.util.ArrayList;
import java.util.List;

import de.aemik.turnierplaner.domain.model.Verein;

public class VereinService {
	
	private VereinRepository vereinRepository;
	
	public VereinService(VereinRepository vereinRepository) {
		this.vereinRepository = vereinRepository;
	}

	public void anlegen(Verein verein) {
		this.vereinRepository.save(verein);
	}
	
	public List<Verein> alle() {
		return new ArrayList<>(this.vereinRepository.findAll());
	}
	
}
