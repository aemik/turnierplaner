package de.aemik.turnierplaner.adapter.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import de.aemik.turnierplaner.domain.model.Spieler;
import de.aemik.turnierplaner.domain.service.SpielerRepository;

@ApplicationScoped
public class SpielerRepositoryMemImpl extends RepositoryMemImpl<Spieler, String> implements SpielerRepository {

	@Override
	public <S extends Spieler> S save(S entity) {
		super.save(entity, entity.getId());
		return entity;
	}

	@Override
	public <S extends Spieler> Iterable<S> saveAll(Iterable<S> entities) {
		for (S entity : entities) {
			super.save(entity, entity.getId());
		}
		return entities;
	}

	@Override
	public Optional<Spieler> findById(String id) {
		return Optional.ofNullable(super.get(id));
	}

	@Override
	public boolean existsById(String id) {
		return (super.get(id) != null);
	}

	@Override
	public Iterable<Spieler> findAll() {
		return super.getAll();
	}

	@Override
	public Iterable<Spieler> findAllById(Iterable<String> ids) {
		List<Spieler> spielerList = new ArrayList<>();
		for (String id : ids) {
			Spieler spieler = super.get(id);
			if (spieler != null) {
				spielerList.add(super.get(id));	
			}
		}
		return spielerList;
	}

	@Override
	public long count() {
		return super.getAll().size();
	}

	@Override
	public void deleteById(String id) {
		super.remove(id);
	}

	@Override
	public void delete(Spieler entity) {
		super.remove(entity.getId());
	}

	@Override
	public void deleteAll(Iterable<? extends Spieler> entities) {
		for (Spieler entity : entities) {
			super.remove(entity.getId());
		}
	}

	@Override
	public void deleteAll() {
		super.clear();
	}

}
