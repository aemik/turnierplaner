package de.aemik.turnierplaner.application.turnier;

import de.aemik.turnierplaner.domain.model.Turnier;
import de.aemik.turnierplaner.domain.service.TurnierRepository;

public class TurnierAnlegen {

	private TurnierRepository turnierRepository;
	
	public TurnierAnlegen(TurnierRepository turnierRepository) {
		this.turnierRepository = turnierRepository;
	}
	
	public void mit(Turnier turnier) {
		turnierRepository.save(turnier);
	}
	
	
}
