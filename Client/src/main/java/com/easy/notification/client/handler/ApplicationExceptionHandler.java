package com.easy.notification.client.handler;

import com.easy.notification.client.utils.JsonResponseUtils;
import com.easy.notification.core.exceptions.ApplicationException;

import javax.json.JsonObject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by skylar on 16.12.15.
 */
@Provider
public class ApplicationExceptionHandler implements ExceptionMapper<ApplicationException> {

    @Override
    public Response toResponse(ApplicationException exception) {
        JsonObject message;
        switch (exception.getCode()) {
            case INVALID_INPUT_DATA:
                message = JsonResponseUtils.buildResponseWith(exception.getMessage());
                break;
            default:
                message = JsonResponseUtils.buildResponseWith(exception.getCode().getMassage());
        }

        return Response.ok(message, MediaType.APPLICATION_JSON_TYPE)
                .status(Response.Status.BAD_REQUEST)
                .build();
    }
}
