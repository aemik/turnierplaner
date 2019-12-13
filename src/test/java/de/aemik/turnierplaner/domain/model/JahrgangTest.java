package de.aemik.turnierplaner.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JahrgangTest {

	@Test
	public void test() {
		assertEquals(Jahrgang.of(2000), Jahrgang.of(2000));
		assertEquals(Jahrgang.of(1900), Jahrgang.of(1900));
		assertEquals(Jahrgang.of(2100), Jahrgang.of(2100));

		assertEquals(Jahrgang.of(2000), Jahrgang.of(2000));
		assertNotEquals(Jahrgang.of(2001), Jahrgang.of(2000));
	}

	@Test
	public void test_min_value() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Jahrgang.of(1899);
		});

	}

	@Test
	public void test_max_value() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Jahrgang.of(2101);
		});
	}

}
