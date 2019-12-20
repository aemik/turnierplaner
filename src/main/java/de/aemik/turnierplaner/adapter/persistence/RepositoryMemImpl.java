package de.aemik.turnierplaner.adapter.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * repository implementation for in-memory data
 * 
 * @author aemik
 *
 * @param <T>  entity
 * @param <ID> entity id
 */
abstract class RepositoryMemImpl<T, ID> {

	private Map<ID, T> memoryMap = new HashMap<>();

	void save(T entity, ID id) {
		memoryMap.put(id, entity);
	}

	Collection<T> getAll() {
		return memoryMap.values();
	}
	
	T get(ID id) {
		return memoryMap.get(id);
	}

	void remove(ID id) {
		memoryMap.remove(id);
	}

	void clear() {
		memoryMap.clear();
	}
	
}
