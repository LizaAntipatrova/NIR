package com.strongkittens.nirstorage.auth.exceptions.data;

public class UnregisteredUserException extends RuntimeException {
    public UnregisteredUserException() {
        super("A user with that login and password was not found.");
    }
}
