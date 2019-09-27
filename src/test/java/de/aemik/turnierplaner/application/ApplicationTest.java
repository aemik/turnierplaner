package de.aemik.turnierplaner.application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.aemik.turnierplaner.adapter.persistence.VereinRepositoryMemImpl;
import de.aemik.turnierplaner.application.verein.AlleVereineAbfragen;
import de.aemik.turnierplaner.application.verein.VereinAnlegen;
import de.aemik.turnierplaner.domain.model.Verein;
import de.aemik.turnierplaner.domain.service.VereinRepository;

public class ApplicationTest {

	@Test
	public void test() {
		VereinRepository vereinRepository = new VereinRepositoryMemImpl();
		new VereinAnlegen(vereinRepository).mit(Verein.of("03002", "SV Böblingen"));
		new VereinAnlegen(vereinRepository).mit(Verein.of("03003", "VFL GSindelfingen"));
		
		
		assertEquals(2, new AlleVereineAbfragen(vereinRepository).get().size());
//		new AlleVereineAbfragen(vereinRepository).get().forEach(System.out::println);

	}

}
