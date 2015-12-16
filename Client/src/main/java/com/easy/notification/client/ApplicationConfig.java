package com.easy.notification.client;

import com.easy.notification.client.controller.CommonController;
import com.easy.notification.client.controller.RegistrationController;
import com.easy.notification.client.handler.ApplicationExceptionHandler;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Max Galich on 14.10.2015.
 */
@ApplicationPath("resources")
public class ApplicationConfig extends Application {

    private final Set<Class<?>> classes;

    public ApplicationConfig() {
        HashSet<Class<?>> controllers = new HashSet<>();
        controllers.add(RegistrationController.class);
        controllers.add(CommonController.class);
        controllers.add(ApplicationExceptionHandler.class);

        classes = Collections.unmodifiableSet(controllers);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
