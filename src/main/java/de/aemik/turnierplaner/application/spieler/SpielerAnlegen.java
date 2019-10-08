package de.aemik.turnierplaner.application.spieler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.aemik.turnierplaner.domain.model.Spieler;
import de.aemik.turnierplaner.domain.service.SpielerRepository;

public class SpielerAnlegen {
	
	final Logger logger = LoggerFactory.getLogger(SpielerAnlegen.class);

	private SpielerRepository spielerRepository;
	
	public SpielerAnlegen(SpielerRepository spielerRepository) {
		this.spielerRepository = spielerRepository;
	}
	
	public void fuer(Spieler spieler) {
		logger.info("save {}", spieler);
		spielerRepository.save(spieler);
	}
	
	
}
