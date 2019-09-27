package de.aemik.turnierplaner.application.turnier;

import java.util.ArrayList;
import java.util.List;

import de.aemik.turnierplaner.domain.model.Turnier;
import de.aemik.turnierplaner.domain.service.TurnierRepository;

public class AlleTurniereAbfragen {

	private TurnierRepository turnierRepository;

	public AlleTurniereAbfragen(TurnierRepository turnierRepository) {
		this.turnierRepository = turnierRepository;
	}

	public List<Turnier> get() {
		List<Turnier> collection = new ArrayList<>();
        turnierRepository.findAll().forEach(collection::add);
        return collection;
	}

}
