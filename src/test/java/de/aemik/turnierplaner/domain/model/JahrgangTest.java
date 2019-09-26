package de.aemik.turnierplaner.domain.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class JahrgangTest {

	@Test
	public void test() {
		assertEquals(2000, Jahrgang.of(2000).get());
		assertEquals(1900, Jahrgang.of(1900).get());
		assertEquals(2100, Jahrgang.of(2100).get());
		
		assertEquals(Jahrgang.of(2000), Jahrgang.of(2000));
		assertNotEquals(Jahrgang.of(2001), Jahrgang.of(2000));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_min_value() {
		Jahrgang.of(1899);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_max_value() {
		Jahrgang.of(2101);
	}

}
