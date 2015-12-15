package com.easy.notification.client.controller;

import com.easy.notification.client.dto.response.Response;
import com.easy.notification.core.bean.Client;
import com.easy.notification.middle.service.UserRegistrationService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Max Galich on 18.10.2015.
 */
@Path("/registration")
public class RegistrationController {

    private static final Logger logger = Logger.getLogger(RegistrationController.class.getName());

    @Inject
    private UserRegistrationService registrationService;

    @POST
    @Produces("application/json")
    public Response registration(Client user) {
        try {
            logger.log(Level.INFO, "Start registration new user {" + user.getId() + "}");
            registrationService.registrationUser(user);
            return Response.ok();
        } catch (Exception ex) {
            return Response.fail(ex.getMessage());
        }
    }

}
