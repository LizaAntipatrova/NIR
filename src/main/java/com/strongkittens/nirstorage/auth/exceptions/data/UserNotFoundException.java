package com.strongkittens.nirstorage.auth.exceptions.data;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("A user with that username was not found.");
    }
}
