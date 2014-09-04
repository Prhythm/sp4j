package com.prhythm.jsp.client.util;

/**
 * Created by Bruce on 9/3/2014.
 */
public class HttpResponseException extends RuntimeException {

    int statusCode;
    String statusDescription;

    public HttpResponseException(int statusCode, String statusDescription) {
        setValue(statusCode, statusDescription);
    }

    public HttpResponseException(int statusCode, String statusDescription, String message) {
        super(message);
        setValue(statusCode, statusDescription);
    }

    public HttpResponseException(int statusCode, String statusDescription, String message, Throwable cause) {
        super(message, cause);
        setValue(statusCode, statusDescription);
    }

    public HttpResponseException(int statusCode, String statusDescription, Throwable cause) {
        super(cause);
        setValue(statusCode, statusDescription);
    }

    void setValue(int statusCode, String statusDescription) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
    }
}
