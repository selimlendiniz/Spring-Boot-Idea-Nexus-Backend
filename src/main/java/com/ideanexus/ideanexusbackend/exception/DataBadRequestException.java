package com.ideanexus.ideanexusbackend.exception;

public class DataBadRequestException extends RuntimeException{
    public DataBadRequestException(String message) {
        super(message);
    }

    public DataBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
