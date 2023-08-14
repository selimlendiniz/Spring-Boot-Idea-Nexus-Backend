package com.ideanexus.ideanexusbackend.exception;

public class BlogNotFoundException extends RuntimeException{

    public BlogNotFoundException(String message) {
        super(message);
    }

    public BlogNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
