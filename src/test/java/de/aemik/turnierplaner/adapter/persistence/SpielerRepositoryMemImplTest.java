package de.aemik.turnierplaner.adapter.persistence;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import de.aemik.turnierplaner.domain.model.Jahrgang;
import de.aemik.turnierplaner.domain.model.Spieler;
import de.aemik.turnierplaner.domain.model.Verein;
import de.aemik.turnierplaner.domain.model.Vereinsnummer;

public class SpielerRepositoryMemImplTest {

	@Test
	public void test() {
		SpielerRepositoryMemImpl repo = new SpielerRepositoryMemImpl();
		Spieler s1 = Spieler.of("max", "mustermann", Jahrgang.of(2000), Verein.of(Vereinsnummer.of("12345"), "SV Musterstadt"));
		Spieler s2 = Spieler.of("moritz", "mustermann", Jahrgang.of(2001), Verein.of(Vereinsnummer.of("12345"), "SV Musterstadt"));
		
		repo.save(s1);
		repo.save(s2);
		
		assertEquals(2, repo.count());
		
		assertEquals(true, repo.existsById(s1.getId()));
		assertEquals(false, repo.existsById("anyId"));
		assertEquals(s1, repo.findById(s1.getId()).get());
		
		repo.delete(s1);
		assertEquals(1, repo.count());
		
		repo.deleteAll();
		assertEquals(0, repo.count());
	}

}
