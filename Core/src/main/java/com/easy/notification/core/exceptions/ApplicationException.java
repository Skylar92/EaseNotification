package com.easy.notification.core.exceptions;

/**
 * Created by skylar on 15.12.15.
 */
public class ApplicationException extends Exception {

    private Code code;

    public ApplicationException(Code code) {
        this.code = code;
    }

    public ApplicationException(String message, Code code) {
        super(message);
        this.code = code;
    }

    public ApplicationException(String message, Throwable cause, Code code) {
        super(message, cause);
        this.code = code;
    }

    public ApplicationException(Throwable cause, Code code) {
        super(cause);
        this.code = code;
    }

    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Code code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public Code getCode() {
        return code;
    }

}
