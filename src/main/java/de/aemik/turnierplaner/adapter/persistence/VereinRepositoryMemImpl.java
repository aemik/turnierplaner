package de.aemik.turnierplaner.adapter.persistence;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import de.aemik.turnierplaner.domain.model.Verein;
import de.aemik.turnierplaner.domain.service.VereinRepository;

@ApplicationScoped
public class VereinRepositoryMemImpl extends RepositoryMemImpl<Verein, String> implements VereinRepository {

	@Override
	public <S extends Verein> S save(S entity) {
		super.save(entity, entity.getNummer());
		return entity;
	}

	@Override
	public <S extends Verein> Iterable<S> saveAll(Iterable<S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<Verein> findById(String id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean existsById(String id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterable<Verein> findAll() {
		return super.getAll();
	}

	@Override
	public Iterable<Verein> findAllById(Iterable<String> ids) {
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
	public void delete(Verein entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAll(Iterable<? extends Verein> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAll() {
		throw new UnsupportedOperationException();
	}

}
