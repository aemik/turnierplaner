package de.aemik.turnierplaner.adapter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class ApplicationLifecycle {

    private final static Logger logger = LoggerFactory.getLogger(ApplicationLifecycle.class);

    @Inject
    private ApplicationSetup applicationSetup;
    
    void onStart(@Observes StartupEvent ev) {               
    	logger.info("The application is starting...");
    	applicationSetup.setupApplication();
    }

    void onStop(@Observes ShutdownEvent ev) {               
    	logger.info("The application is stopping...");
    }

}