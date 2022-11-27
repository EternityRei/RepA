package com.example.repa.exception;

public class AlreadyCreatedEntityException extends RuntimeException{
    public AlreadyCreatedEntityException(String message) {
        super(message);
    }
}
