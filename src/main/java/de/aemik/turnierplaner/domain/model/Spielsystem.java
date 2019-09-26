package de.aemik.turnierplaner.domain.model;

import java.util.List;

public interface Spielsystem {

	List<Spielpaarung> erstelleSpielpaarungenFuer(List<Spieler> spieler);
	
}
