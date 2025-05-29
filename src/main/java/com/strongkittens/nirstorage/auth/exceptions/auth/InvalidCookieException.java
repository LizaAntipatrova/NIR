package com.strongkittens.nirstorage.auth.exceptions.auth;

public class InvalidCookieException extends RuntimeException {
    public InvalidCookieException() {
        super("Invalid Cookie");
    }
}
