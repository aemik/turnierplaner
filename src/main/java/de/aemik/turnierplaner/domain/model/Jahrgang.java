package de.aemik.turnierplaner.domain.model;

import de.aemik.turnierplaner.domain.ValueObject;

/**
 * 
 * @category value object
 * 
 */
public class Jahrgang extends ValueObject<Integer> {

	private Jahrgang(int value) {
		super(value);
	}

	private final static int MIN = 1900;
	private final static int MAX = 2100;

	public static Jahrgang of(int value) {
		if (value < MIN || value > MAX) {
			throw new IllegalArgumentException("not valid value. Must be between " + MIN + " and " + MAX);
		}
		return new Jahrgang(value);
	}

}
