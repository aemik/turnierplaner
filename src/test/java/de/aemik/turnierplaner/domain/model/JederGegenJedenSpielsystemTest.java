package de.aemik.turnierplaner.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class JederGegenJedenSpielsystemTest {

	@Test
	void test() {
		JederGegenJedenSpielsystem spielsystem = new JederGegenJedenSpielsystem();
		Set<Spieler> spieler = new HashSet<>();
		
		spieler.add(Spieler.of("max", "mustermann", Jahrgang.of(2000),
				Verein.of(Vereinsnummer.of("12345"), "SV Musterstadt")));
		assertEquals(0, spielsystem.erstelleSpielpaarungenFuer(spieler).size());
		
		spieler.add(Spieler.of("max", "mustermann", Jahrgang.of(2000),
				Verein.of(Vereinsnummer.of("12345"), "SV Musterstadt")));
		assertEquals(1, spielsystem.erstelleSpielpaarungenFuer(spieler).size());
		
		
		spieler.add(Spieler.of("max", "mustermann", Jahrgang.of(2000),
				Verein.of(Vereinsnummer.of("12345"), "SV Musterstadt")));
		assertEquals(3, spielsystem.erstelleSpielpaarungenFuer(spieler).size());
		
	}

}
