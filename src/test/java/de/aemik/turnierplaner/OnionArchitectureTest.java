package de.aemik.turnierplaner;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

import org.junit.runner.RunWith;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;

/**
 * test to be sure that ddd architecture is still valid
 * 
 * @author aemik
 *
 */
@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "de.aemik.turnierplaner", importOptions = ImportOption.DoNotIncludeTests.class)
public class OnionArchitectureTest {

	@ArchTest
    static final ArchRule onion_architecture_is_respected = onionArchitecture()
            .domainModels("..domain.model..")
            .domainServices("..domain.service..")
            .applicationServices("..application..")
            .adapter("persistence", "..adapter.persistence..")
            .adapter("rest","..adapter.rest..");
}
