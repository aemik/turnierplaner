package de.aemik.turnierplaner.application;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.aemik.turnierplaner.domain.model.Turnier;
import de.aemik.turnierplaner.domain.service.TurnierRepository;

@RequestScoped
public class TurnierService {

	private final static Logger logger = LoggerFactory.getLogger(TurnierService.class);

	private TurnierRepository turnierRepository;

	@Inject
	public TurnierService(TurnierRepository turnierRepository) {
		this.turnierRepository = turnierRepository;
	}

	public List<Turnier> getAll() {
		List<Turnier> collection = new ArrayList<>();
		turnierRepository.findAll().forEach(collection::add);
		return collection;
	}

	public void create(Turnier turnier) {
		logger.info("save {}", turnier);
		turnierRepository.save(turnier);
	}

}
