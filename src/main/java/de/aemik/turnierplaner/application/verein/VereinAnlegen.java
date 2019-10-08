package de.aemik.turnierplaner.application.verein;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.aemik.turnierplaner.domain.model.Verein;
import de.aemik.turnierplaner.domain.service.VereinRepository;

public class VereinAnlegen {
	
	final Logger logger = LoggerFactory.getLogger(VereinAnlegen.class);

	private VereinRepository vereinRepository;
	
	public VereinAnlegen(VereinRepository vereinRepository) {
		this.vereinRepository = vereinRepository;
	}
	
	public void mit(Verein verein) {
		logger.info("save {}", verein);
		vereinRepository.save(verein);
	}
	
	
}
