package com.easy.notification.client.controller;

import com.easy.notification.core.bean.Service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Collections;
import java.util.List;

/**
 * Created by skylar on 06.11.15.
 */
@Path("/common")
public class CommonController {

    @POST
    @Produces("application/json")
    @Path("services")
    public List<Service> getAvailableService() {
        //this mock is temporary
        Service service = new Service("Olx", "http://www.olx.ua", "description");
        return Collections.singletonList(service);
    }


}
