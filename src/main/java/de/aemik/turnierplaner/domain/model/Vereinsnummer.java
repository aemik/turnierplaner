package de.aemik.turnierplaner.domain.model;

import de.aemik.turnierplaner.domain.BaseType;

/**
 * 
 * @category value object
 * 
 */
public class Vereinsnummer extends BaseType<String> {

	private static final int LENGTH = 5;

	private Vereinsnummer(String value) {
		super(value);
	}
	
	public static Vereinsnummer of(String value) {
		try {
			Integer.parseInt(value);			
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("not valid value. Must be numeric");
		}
		
		if (value.length() != LENGTH) {
			throw new IllegalArgumentException("not valid value. Must be " + LENGTH + " chars long");
		}
		return new Vereinsnummer(value);
	}

}
