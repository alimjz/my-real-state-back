package com.mavaratech.myrealstate.exceptions;

public class HttpInvocationException extends RuntimeException{

    public HttpInvocationException(String message) {
        super(message);
    }

    public HttpInvocationException(String message, Throwable cause) {
        super(message, cause);
    }
}
