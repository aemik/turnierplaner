package de.aemik.turnierplaner.adapter.rest;

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
import de.aemik.turnierplaner.application.TurnierService;
import de.aemik.turnierplaner.domain.model.Turnier;

@Path("/turnier")
@ApplicationScoped
public class TurnierResource {

	@Inject
	TurnierService turnierService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TurnierJson> getTurniere() {
		List<TurnierJson> turnierJson = new ArrayList<>();
		turnierService.getAll().stream().forEach(t -> turnierJson.add(TurnierJson.of(t)));
		return turnierJson;
	}

	@PUT
	@Path("/{id}/erstellespielpaarungen")
	public void erstelleSpielpaarungen(@PathParam("id") String id) {
		Optional<Turnier> turnierOptional = turnierService.get(id);

		if (!turnierOptional.isPresent()) {
			throw new NotFoundException();
		}

		Turnier turnier = turnierOptional.get();
		turnier.spielpaarungenErstellen();

		turnierService.save(turnier);
	}
}
