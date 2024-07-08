package com.duynb.spring.crud.exception;

import com.duynb.spring.crud.constant.MainConstants;
import com.duynb.spring.crud.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class Exception {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public Exception(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }
    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
