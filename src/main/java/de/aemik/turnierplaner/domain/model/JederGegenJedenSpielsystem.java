package de.aemik.turnierplaner.domain.model;

import java.util.HashSet;
import java.util.Set;

public class JederGegenJedenSpielsystem implements Spielsystem {

	@Override
	public Set<Spielpaarung> erstelleSpielpaarungenFuer(Set<Spieler> spieler) {
		Set<Spielpaarung> spielpaarungen  = new HashSet<>();
		
		for (Spieler spieler1 : spieler) {
			for (Spieler spieler2 : spieler) {
				if (spieler1.equals(spieler2)) {
					continue;
				}
				Spielpaarung newSpielpaarung = Spielpaarung.create(spieler1, spieler2);
				
				if (spielpaarungen.stream().anyMatch(s -> s.isSameSpielpaarung(newSpielpaarung))) {
					continue;
				}
				spielpaarungen.add(newSpielpaarung);
			}
		}
		
		return spielpaarungen;
	}

}
