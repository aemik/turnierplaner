package de.aemik.turnierplaner.adapter.persistence;

import java.util.Optional;

import de.aemik.turnierplaner.domain.model.Spieler;
import de.aemik.turnierplaner.domain.service.SpielerRepository;

public class SpielerRepositoryMemImpl extends RepositoryMemImpl<Spieler, String> implements SpielerRepository {

	@Override
	public <S extends Spieler> S save(S entity) {
		super.save(entity, entity.getId());
		return entity;
	}

	@Override
	public <S extends Spieler> Iterable<S> saveAll(Iterable<S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<Spieler> findById(String id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean existsById(String id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterable<Spieler> findAll() {
		return super.getAll();
	}

	@Override
	public Iterable<Spieler> findAllById(Iterable<String> ids) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long count() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteById(String id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Spieler entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAll(Iterable<? extends Spieler> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAll() {
		throw new UnsupportedOperationException();
	}

}
