package de.aemik.turnierplaner.domain;

import java.util.Objects;


/**
 * A value object type for types that are based on one technical type.
 *
 * @param <T> type
 */
public abstract class ValueObject<T> {
	
	private final T value;

	protected ValueObject(T value) {
		Objects.requireNonNull(value, "value is required");
		this.value = value;
	}

	public final T value() {
		return value;
	}

	@Override
	public final int hashCode() {
		return value.hashCode();
	}
	
	@Override
	public final String toString() {
		return getClass().getSimpleName() + " [" + value() + "]";
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		ValueObject other = (ValueObject) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
}