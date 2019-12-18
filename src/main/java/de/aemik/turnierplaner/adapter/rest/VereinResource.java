package de.aemik.turnierplaner.adapter.rest;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.aemik.turnierplaner.adapter.ApplicationSetup;
import de.aemik.turnierplaner.adapter.rest.model.VereinJson;
import de.aemik.turnierplaner.application.VereinService;
import de.aemik.turnierplaner.domain.model.Verein;
import de.aemik.turnierplaner.domain.model.Vereinsnummer;

@Path("/verein")
@ApplicationScoped
public class VereinResource {

	@Inject
	VereinService vereinService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VereinJson> getVereine() {
		List<VereinJson> vereinJsons = new ArrayList<>();
		vereinService.getAll().stream().forEach(v -> vereinJsons.add(VereinJson.of(v)));
		return vereinJsons;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public VereinJson postVerein(VereinJson vereinJson) {
		vereinService.create(Verein.of(Vereinsnummer.of(vereinJson.nummer), vereinJson.name));
		return vereinJson;
	}
}
