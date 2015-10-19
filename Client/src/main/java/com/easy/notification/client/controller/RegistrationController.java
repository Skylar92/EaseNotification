package com.easy.notification.client.controller;

import com.easy.notification.client.dto.response.Response;
import com.easy.notification.core.bean.Client;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.logging.Logger;

/**
 * Created by Max Galich on 18.10.2015.
 */
@Path("/registration")
public class RegistrationController {

    private static final Logger logger = Logger.getLogger(RegistrationController.class.getName());

    @POST
    @Produces("application/json")
    public Response registration(Client client) {
        try {
            logger.info("Registration new client " + client);
            return Response.ok();
        } catch (Exception ex) {
            return Response.ResponseBuilder.createBuilder().status(Response.Status.FAIL).message(ex.getMessage()).build();
        }
    }

}
