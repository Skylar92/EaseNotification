package com.easy.notification.client.controller;

import com.easy.notification.client.utils.JsonResponseUtils;
import com.easy.notification.core.bean.Client;
import com.easy.notification.middle.service.ClientAuthenticationService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Max Galich on 18.10.2015.
 */
@Path("/registration")
public class RegistrationController {

    @Inject
    private ClientAuthenticationService registrationService;

    @POST
    @Produces("application/json")
    public Response registration(Client client) {
        registrationService.registrationClient(client);
        return Response.ok(JsonResponseUtils.ok(), MediaType.APPLICATION_JSON_TYPE).build();
    }

}
