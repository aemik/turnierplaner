package de.aemik.turnierplaner.domain.model;

import java.time.LocalDate;

import org.junit.Test;

public class TurnierTest {

	@Test
	public void test() {
		Verein verein = Verein.of("03002", "SV Böblingen");

		Turnier turnier = Turnier.create(LocalDate.now(), verein, new JederGegenJedenSpielsystem());

		turnier.meldeAn(Spieler.of("Emanuel", "Egger", Jahrgang.of(1984), verein));
		turnier.meldeAn(Spieler.of("Arno", "Egger", Jahrgang.of(1989), verein));
		turnier.meldeAn(Spieler.of("Rouven", "Egger", Jahrgang.of(1986), verein));
		turnier.meldeAn(Spieler.of("Werner", "Egger", Jahrgang.of(1959), verein));
		turnier.meldeAn(Spieler.of("Renate", "Egger", Jahrgang.of(1954), verein));
		turnier.meldeAn(Spieler.of("Josefine", "Egger", Jahrgang.of(2014), verein));
		turnier.meldeAn(Spieler.of("Victoria", "Egger", Jahrgang.of(1987), verein));

		turnier.spielpaarungenErstellen();
		
		turnier.getSpielpaarungen().forEach(s -> s.setGewinner(s.getSpieler1()));
		turnier.getSpielpaarungen().forEach(s -> System.out.println(s.toReadableString()));

	}

}
