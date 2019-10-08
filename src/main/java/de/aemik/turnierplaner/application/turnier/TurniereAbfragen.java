package de.aemik.turnierplaner.application.turnier;

import java.util.ArrayList;
import java.util.List;

import de.aemik.turnierplaner.domain.model.Turnier;
import de.aemik.turnierplaner.domain.service.TurnierRepository;

public class TurniereAbfragen {

	private TurnierRepository turnierRepository;

	public TurniereAbfragen(TurnierRepository turnierRepository) {
		this.turnierRepository = turnierRepository;
	}

	public List<Turnier> getAll() {
		List<Turnier> collection = new ArrayList<>();
        turnierRepository.findAll().forEach(collection::add);
        return collection;
	}

}
