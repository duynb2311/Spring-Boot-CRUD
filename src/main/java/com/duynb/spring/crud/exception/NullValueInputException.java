package com.duynb.spring.crud.exception;

public class NullValueInputException extends RuntimeException{
    public NullValueInputException(String message) {
        super(message);
    }
}
