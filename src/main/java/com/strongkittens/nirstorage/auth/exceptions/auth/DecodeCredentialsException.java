package com.strongkittens.nirstorage.auth.exceptions.auth;

public class DecodeCredentialsException extends RuntimeException {
    public DecodeCredentialsException() {
        super("It is not possible to decode credentials with base64");
    }
}
