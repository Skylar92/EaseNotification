package com.easy.notification.client.controller;

import com.easy.notification.client.dto.response.AvailableServiceResponse;
import com.easy.notification.client.dto.response.Response;
import com.easy.notification.core.bean.Service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by skylar on 06.11.15.
 */
@Path("/common")
public class CommonController {

    @POST
    @Produces("application/json")
    @Path("services")
    public Response getAvailableService() {
        try {
            //this mock is temporary
            Service service = new Service("Olx", "http://www.olx.ua", "description");
            return AvailableServiceResponse.createServiceResponse().addService(service);
        } catch (Exception ex) {
            return Response.fail(ex.getMessage());
        }
    }


}
