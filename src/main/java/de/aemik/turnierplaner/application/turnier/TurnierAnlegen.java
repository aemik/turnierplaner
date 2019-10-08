package de.aemik.turnierplaner.application.turnier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.aemik.turnierplaner.domain.model.Turnier;
import de.aemik.turnierplaner.domain.service.TurnierRepository;

public class TurnierAnlegen {

	final Logger logger = LoggerFactory.getLogger(TurnierAnlegen.class);
	
	private TurnierRepository turnierRepository;
	
	public TurnierAnlegen(TurnierRepository turnierRepository) {
		this.turnierRepository = turnierRepository;
	}
	
	public void mit(Turnier turnier) {
		logger.info("save {}", turnier);
		turnierRepository.save(turnier);
	}
	
	
}
