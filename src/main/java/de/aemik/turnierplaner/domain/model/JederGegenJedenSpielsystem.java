package de.aemik.turnierplaner.domain.model;

import java.util.ArrayList;
import java.util.List;

public class JederGegenJedenSpielsystem implements Spielsystem {

	@Override
	public List<Spielpaarung> erstelleSpielpaarungenFuer(List<Spieler> spieler) {
		List<Spielpaarung> spielpaarungen  = new ArrayList<>();;
		
		for (Spieler spieler1 : spieler) {
			for (Spieler spieler2 : spieler) {
				if (!spieler1.equals(spieler2)) {
					spielpaarungen.add(Spielpaarung.create(spieler1, spieler2));
				}
			}
		}
		
		return spielpaarungen;
	}

}
