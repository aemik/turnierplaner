package de.aemik.turnierplaner.adapter;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import de.aemik.turnierplaner.application.SpielerService;
import de.aemik.turnierplaner.application.TurnierService;
import de.aemik.turnierplaner.application.VereinService;
import de.aemik.turnierplaner.domain.model.Jahrgang;
import de.aemik.turnierplaner.domain.model.JederGegenJedenSpielsystem;
import de.aemik.turnierplaner.domain.model.Spieler;
import de.aemik.turnierplaner.domain.model.Turnier;
import de.aemik.turnierplaner.domain.model.Verein;
import de.aemik.turnierplaner.domain.model.Vereinsnummer;

@Dependent
public class ApplicationSetup {

	@Inject
	SpielerService spielerService;
	
	@Inject
	TurnierService turnierService;
	
	@Inject
	VereinService vereinService;

	
	public void setupApplication() {
		Verein verein = Verein.of(Vereinsnummer.of("03002"), "SV Böblingen");
		vereinService.create(verein);
		
		Spieler spieler1 = Spieler.of("Emanuel", "Egger", Jahrgang.of(1984), verein);
		Spieler spieler2 = Spieler.of("Arno", "Egger", Jahrgang.of(1989), verein);
		Spieler spieler3 = Spieler.of("Rouven", "Egger", Jahrgang.of(1986), verein);
		spielerService.create(spieler1);
		spielerService.create(spieler2);
		spielerService.create(spieler3);
		
		Turnier turnier = Turnier.create(LocalDate.now(), verein, new JederGegenJedenSpielsystem());
		turnier.meldeAn(spieler1);
		turnier.meldeAn(spieler2);
		turnier.meldeAn(spieler3);
		turnierService.save(turnier);
	
	}
}
