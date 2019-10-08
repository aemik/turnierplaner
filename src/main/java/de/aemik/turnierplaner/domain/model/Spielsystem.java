package de.aemik.turnierplaner.domain.model;

import java.util.Set;

public interface Spielsystem {

	Set<Spielpaarung> erstelleSpielpaarungenFuer(Set<Spieler> spieler);
	
}
