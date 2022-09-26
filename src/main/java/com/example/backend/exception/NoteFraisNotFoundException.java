package com.example.backend.exception;

import java.util.function.Supplier;

public class NoteFraisNotFoundException extends RuntimeException {
    public NoteFraisNotFoundException(String s) {
        super(s);
    }
}