package com.duynb.spring.crud.exception;

public class DuplicateException extends RuntimeException  {
    public DuplicateException(String message) {
        super(message);
    }
}
