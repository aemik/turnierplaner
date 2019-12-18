package de.aemik.turnierplaner.adapter.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.aemik.turnierplaner.domain.model.JederGegenJedenSpielsystem;
import de.aemik.turnierplaner.domain.model.Turnier;
import de.aemik.turnierplaner.domain.model.Verein;
import de.aemik.turnierplaner.domain.model.Vereinsnummer;

public class TurnierRepositoryMemImplTest {

	@Test
	public void test() {
		TurnierRepositoryMemImpl repo = new TurnierRepositoryMemImpl();
		assertEquals(0, repo.count());
		
		Turnier turnier1 = Turnier.create(LocalDate.now(), Verein.of(Vereinsnummer.of("12345"), "dummy"), new JederGegenJedenSpielsystem());
		Turnier turnier2 = Turnier.create(LocalDate.now(), Verein.of(Vereinsnummer.of("12345"), "dummy2"), new JederGegenJedenSpielsystem());
		
		repo.save(turnier1, "1");
		repo.save(turnier2, "2");
		
		assertEquals(turnier1, repo.findById("1").get());
		assertEquals(turnier2, repo.findById("2").get());
		assertEquals(2, repo.count());
		
		repo.deleteById("1");
		assertEquals(1, repo.count());
		
		repo.deleteAll();
		assertEquals(0, repo.count());
	}

}
