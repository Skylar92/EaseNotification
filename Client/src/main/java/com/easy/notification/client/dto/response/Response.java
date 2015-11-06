package com.easy.notification.client.dto.response;

/**
 * Created by Max Galich on 19.10.2015.
 */
public class Response {

    private static Response OK_RESPONSE = new Response(Status.OK, null);

    private Status status;
    private String message;

    protected Response(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public enum Status {
        OK,
        FAIL
    }

    public static Response ok() {
        return OK_RESPONSE;
    }

    public static Response fail(String message) {
        return new Response(Status.FAIL, message);
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        if (status != response.status) return false;
        return !(message != null ? !message.equals(response.message) : response.message != null);

    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
