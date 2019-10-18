package de.aemik.turnierplaner.domain;

import java.util.Objects;

public abstract class BaseType<T> {
	
	private final T value;

	protected BaseType(T value) {
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
		BaseType other = (BaseType) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
}