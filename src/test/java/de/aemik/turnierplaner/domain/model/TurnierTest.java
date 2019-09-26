package de.aemik.turnierplaner.domain.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class TurnierTest {

	@Test
	public void test() {
		Turnier turnier = Turnier.create(LocalDate.of(2019, 1, 1), Verein.of("03002", "SV Böblingen"), new JederGegenJedenSpielsystem());
	
		turnier.meldeAn(Spieler.create("Emanuel", "Egger", Jahrgang.of(1984) , Verein.of("03002", "SV Böblingen")));
		turnier.meldeAn(Spieler.create("Arno", "Egger", Jahrgang.of(1989) , Verein.of("03002", "SV Böblingen")));
		turnier.meldeAn(Spieler.create("Rouven", "Egger", Jahrgang.of(1986) , Verein.of("03002", "SV Böblingen")));
		
		turnier.spielpaarungenErstellen();
		
		assertEquals(6, turnier.getSpielpaarungen().size());
		
//		System.out.println(turnier);
	}

}
