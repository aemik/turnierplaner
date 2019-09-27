package de.aemik.turnierplaner.application.verein;

import de.aemik.turnierplaner.domain.model.Verein;
import de.aemik.turnierplaner.domain.service.VereinRepository;

public class VereinAnlegen {

	private VereinRepository vereinRepository;
	
	public VereinAnlegen(VereinRepository vereinRepository) {
		this.vereinRepository = vereinRepository;
	}
	
	public void mit(Verein verein) {
		vereinRepository.save(verein);
	}
	
	
}
