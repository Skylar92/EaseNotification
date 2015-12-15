package com.easy.notification.core.exceptions;

/**
 * Created by skylar on 15.12.15.
 */
public enum Code {

    UNKNOWN("Unknown message");

    private String massage;

    Code(String message) {
        this.massage = message;
    }

    public String getMassage() {
        return massage;
    }
}
