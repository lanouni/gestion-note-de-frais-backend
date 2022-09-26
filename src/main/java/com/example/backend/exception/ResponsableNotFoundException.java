package com.example.backend.exception;

public class ResponsableNotFoundException extends RuntimeException {
    public ResponsableNotFoundException(String message) {
        super(message);
    }
}