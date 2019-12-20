package de.aemik.turnierplaner.adapter.rest.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.aemik.turnierplaner.adapter.rest.model.TurnierJson;
import de.aemik.turnierplaner.application.SpielerService;
import de.aemik.turnierplaner.application.TurnierService;
import de.aemik.turnierplaner.domain.model.Spieler;
import de.aemik.turnierplaner.domain.model.Spielpaarung;
import de.aemik.turnierplaner.domain.model.Turnier;

@Path("/turnier")
@ApplicationScoped
public class TurnierResource {

	@Inject
	TurnierService turnierService;

	@Inject
	SpielerService spielerService;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TurnierJson> getTurniere() {
		List<TurnierJson> turnierJson = new ArrayList<>();
		turnierService.getAll().stream().forEach(t -> turnierJson.add(TurnierJson.of(t)));
		return turnierJson;
	}

	@PUT
	@Path("/{turnierid}/erstellespielpaarungen")
	public void erstelleSpielpaarungen(@PathParam("turnierid") String turnierid) {
		Optional<Turnier> turnierOptional = turnierService.get(turnierid);

		if (!turnierOptional.isPresent()) {
			throw new NotFoundException();
		}

		Turnier turnier = turnierOptional.get();
		turnier.spielpaarungenErstellen();

		turnierService.save(turnier);
	}

	@PUT
	@Path("/{turnierid}/spielpaarung/{spielpaarungid}/gewinner/{spielerid}")
	public void erstelleSpielpaarungen(@PathParam("turnierid") String turnierid,
			@PathParam("spielpaarungid") String spielpaarungid, @PathParam("spielerid") String spielerid) {
		Optional<Turnier> turnierOptional = turnierService.get(turnierid);
		if (!turnierOptional.isPresent()) {
			throw new NotFoundException();
		}
		Turnier turnier = turnierOptional.get();
		
		Optional<Spielpaarung> spielpaarungOptional = turnier.getSpielpaarungById(spielpaarungid);
		if (!spielpaarungOptional.isPresent()) {
			throw new NotFoundException();
		}
		Spielpaarung spielpaarung = spielpaarungOptional.get();
		
		Optional<Spieler> spielerOptional = turnier.getGemeldetenSpielerById(spielerid);
		if (!spielerOptional.isPresent()) {
			throw new NotFoundException();
		}
		Spieler spieler = spielerOptional.get();
		
		spielpaarung.setGewinner(spieler);

		turnierService.save(turnier);
	}
}
