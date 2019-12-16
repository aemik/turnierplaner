package de.aemik.turnierplaner.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpielerTest {

	static final Verein verein = Verein.of(Vereinsnummer.of("12345"), "SV Musterstadt");
	static final Jahrgang jahrgang= Jahrgang.of(2000);

	@Test
	public void test_success() {
		assertEquals(Spieler.of("max", "mustermann", jahrgang, verein),
				Spieler.of("max", "mustermann", jahrgang, verein));
	}

	@Test
	public void test_id_handling() {
		Spieler spieler = Spieler.of("max", "mustermann", jahrgang, verein);
		
		String id = spieler.getId();
		assertNotNull(id);
		
		Spieler spieler2 = Spieler.restore(id, "max", "mustermann", jahrgang, verein);
		assertEquals(id, spieler2.getId());
	}
	
	@Test
	public void test_invalid_attributes() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Spieler.of(null, "mustermann", jahrgang, verein);
		});
		Assertions.assertThrows(NullPointerException.class, () -> {
			Spieler.of("max", null, jahrgang, verein);
		});
		Assertions.assertThrows(NullPointerException.class, () -> {
			Spieler.of("max", "mustermann", null, verein);
		});
		Assertions.assertThrows(NullPointerException.class, () -> {
			Spieler.of("max", "mustermann", jahrgang, null);
		});

	}


}
