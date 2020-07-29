package com.zucchetti.blogz.api.gateway.lifecycle;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.jboss.logging.Logger;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class AppLifecycleBean {

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    void onStart(@Observes StartupEvent ev) {               
        LOGGER.info("blogz-api-gateway application is starting...");
    }

    void onStop(@Observes ShutdownEvent ev) {               
        LOGGER.info("blogz-api-gateway application is stopping...");
    }

}
