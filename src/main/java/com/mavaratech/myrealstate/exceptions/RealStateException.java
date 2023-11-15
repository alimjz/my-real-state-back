package com.mavaratech.myrealstate.exceptions;

public class RealStateException extends RuntimeException{

    public RealStateException(String message) {
        super(message);
    }

    public RealStateException(String message, Throwable cause) {
        super(message, cause);
    }
}
