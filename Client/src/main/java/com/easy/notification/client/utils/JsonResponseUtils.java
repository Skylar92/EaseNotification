package com.easy.notification.client.utils;

import javax.json.Json;
import javax.json.JsonObject;

/**
 * Created by skylar on 16.12.15.
 */
public class JsonResponseUtils {

    private static final String NAME = "message";
    private static final String OK = "ok";

    public static JsonObject ok() {
        return Json.createObjectBuilder().add(NAME, OK).build();
    }

    public static JsonObject buildResponseWith(String message) {
        return Json.createObjectBuilder().add(NAME, message).build();
    }



}
