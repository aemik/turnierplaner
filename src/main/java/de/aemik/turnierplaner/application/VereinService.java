package de.aemik.turnierplaner.application;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.aemik.turnierplaner.domain.model.Verein;
import de.aemik.turnierplaner.domain.service.VereinRepository;


@RequestScoped
public class VereinService {

	private final static Logger logger = LoggerFactory.getLogger(VereinService.class);
	
	private VereinRepository vereinRepository;

	@Inject
	public VereinService(VereinRepository vereinRepository) {
		this.vereinRepository = vereinRepository;
	}

	public List<Verein> getAll() {
		List<Verein> collection = new ArrayList<>();
		vereinRepository.findAll().forEach(collection::add);
		return collection;
	}
	
	public void create(Verein verein) {
		logger.info("save {}", verein);
		vereinRepository.save(verein);
	}

}
