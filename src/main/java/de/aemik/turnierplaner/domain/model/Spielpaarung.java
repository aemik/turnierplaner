package de.aemik.turnierplaner.domain.model;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import de.aemik.turnierplaner.domain.DomainObject;

/**
 * 
 * @category domain object
 * 
 */
public class Spielpaarung extends DomainObject {

	private Spieler spieler1;
	private Spieler spieler2;
	private Optional<Spieler> gewinner;

	private Spielpaarung(String id, Spieler spieler1, Spieler spieler2) {
		super(id);
		
		Objects.requireNonNull(spieler1, "spieler1 is required");
		Objects.requireNonNull(spieler2, "spieler2 is required");

		this.spieler1 = spieler1;
		this.spieler2 = spieler2;
		this.gewinner = Optional.empty();
	}

	public static Spielpaarung create(Spieler spieler1, Spieler spieler2) {
		return new Spielpaarung(null, spieler1, spieler2);
	}

	public static Spielpaarung restore(String id, Spieler spieler1, Spieler spieler2) {
		return new Spielpaarung(id, spieler1, spieler2);
	}

	public String getId() {
		return id;
	}

	public Spieler getSpieler1() {
		return spieler1;
	}

	public Spieler getSpieler2() {
		return spieler2;
	}

	public void setGewinner(Spieler spieler) {
		if (!spieler1.equals(spieler) && !spieler2.equals(spieler)) {
			throw new IllegalArgumentException("not valid spieler for this spielpaarung!");
		}
		this.gewinner = Optional.of(spieler);
	}

	public Optional<Spieler> getGewinner() {
		return gewinner;
	}
	
	public boolean isSameSpielpaarung(Spielpaarung spielpaarung) {
		if (spielpaarung == null) {
			return false;			
		} else if (this.spieler1.equals(spielpaarung.getSpieler1()) && this.spieler2.equals(spielpaarung.getSpieler2())) {
			return true;	
		} else if (this.spieler1.equals(spielpaarung.getSpieler2()) && this.spieler2.equals(spielpaarung.getSpieler1())) {
			return true;	
		} else {
			return false;	
		}
	}

	public String toReadableString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Spielpaarung: ");
		builder.append(spieler1.getFullname());
		builder.append(" vs. ");
		builder.append(spieler2.getFullname());

		if (gewinner.isPresent()) {
			if (gewinner.get().equals(spieler1)) {
				builder.append(" 1:0");
			} else if (gewinner.get().equals(spieler2)) {
				builder.append(" 0:1");
			}
		}

		return builder.toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Spielpaarung [id=");
		builder.append(id);
		builder.append(", spieler1=");
		builder.append(spieler1);
		builder.append(", spieler2=");
		builder.append(spieler2);
		builder.append(", gewinner=");
		builder.append(gewinner);
		builder.append("]");
		return builder.toString();
	}

}
