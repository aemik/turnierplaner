package de.aemik.turnierplaner.application;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.aemik.turnierplaner.domain.model.Spieler;
import de.aemik.turnierplaner.domain.service.SpielerRepository;

@RequestScoped
public class SpielerService {

	private static final Logger logger = LoggerFactory.getLogger(SpielerService.class);

	private SpielerRepository spielerRepository;

	@Inject
	public SpielerService(SpielerRepository spielerRepository) {
		this.spielerRepository = spielerRepository;
	}

	public List<Spieler> getAll() {
		List<Spieler> collection = new ArrayList<>();
		spielerRepository.findAll().forEach(collection::add);
		return collection;
	}

	public void create(Spieler spieler) {
		logger.info("save {}", spieler);
		spielerRepository.save(spieler);
	}

}
