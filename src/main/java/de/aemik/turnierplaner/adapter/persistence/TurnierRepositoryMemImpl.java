package de.aemik.turnierplaner.adapter.persistence;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import de.aemik.turnierplaner.domain.model.Turnier;
import de.aemik.turnierplaner.domain.service.TurnierRepository;

@ApplicationScoped
public class TurnierRepositoryMemImpl extends RepositoryMemImpl<Turnier, String> implements TurnierRepository {

	@Override
	public <S extends Turnier> S save(S entity) {
		super.save(entity, entity.getId());
		return entity;
	}

	@Override
	public <S extends Turnier> Iterable<S> saveAll(Iterable<S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<Turnier> findById(String id) {
		return Optional.ofNullable(super.get(id));
	}

	@Override
	public boolean existsById(String id) {
		return findById(id).isPresent();
	}

	@Override
	public Iterable<Turnier> findAll() {
		return super.getAll();
	}

	@Override
	public Iterable<Turnier> findAllById(Iterable<String> ids) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long count() {
		return super.getAll().size();
	}

	@Override
	public void deleteById(String id) {
		remove(id);
	}

	@Override
	public void delete(Turnier entity) {
		remove(entity.getId());
	}

	@Override
	public void deleteAll(Iterable<? extends Turnier> entities) {
		for (Turnier entity : entities) {
			delete(entity);
		}
	}

	@Override
	public void deleteAll() {
		clear();
	}

}
