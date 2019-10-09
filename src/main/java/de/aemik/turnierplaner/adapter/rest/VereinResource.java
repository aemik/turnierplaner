package de.aemik.turnierplaner.adapter.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.aemik.turnierplaner.application.VereinService;
import de.aemik.turnierplaner.domain.model.Verein;

@Path("/verein")
@ApplicationScoped
public class VereinResource {

	@Inject
	VereinService vereinService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Verein> getVereine() {
		return vereinService.getAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public VereinJson postVerein(VereinJson vereinJson) {
		vereinService.create(Verein.of(vereinJson.nummer, vereinJson.name));
		return vereinJson;
	}
}