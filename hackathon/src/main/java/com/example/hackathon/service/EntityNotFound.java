package com.example.hackathon.service;

public class EntityNotFound extends RuntimeException {

    public EntityNotFound(String message) {
        super(message);
    }
}
