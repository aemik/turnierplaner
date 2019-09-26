package de.aemik.turnierplaner.domain.model;

public class Jahrgang {
	
	private final static int MIN = 1900;
	private final static int MAX = 2100;

	private int value;
	
	private Jahrgang(int value) {
		this.value = value;
	}
	
	public static Jahrgang of(int value) {
		if (value < MIN || value > MAX) {
			throw new IllegalArgumentException("not valid value. Must be between " + MIN + " and " + MAX);
		}
		return new Jahrgang(value);
	}

	public int get() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jahrgang other = (Jahrgang) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
}
