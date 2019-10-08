package de.aemik.turnierplaner.application.spieler;

import java.util.ArrayList;
import java.util.List;

import de.aemik.turnierplaner.domain.model.Spieler;
import de.aemik.turnierplaner.domain.service.SpielerRepository;

public class SpielerAbfragen {

	private SpielerRepository spielerRepository;

	public SpielerAbfragen(SpielerRepository spielerRepository) {
		this.spielerRepository = spielerRepository;
	}

	public List<Spieler> getAll() {
		List<Spieler> collection = new ArrayList<>();
		spielerRepository.findAll().forEach(collection::add);
        return collection;
	}

}
