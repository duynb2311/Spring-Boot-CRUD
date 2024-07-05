package com.duynb.spring.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ResponseStructure <T> {
    private int statusCode;
    private String message;
    private T data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseStructure() {
    }

    public ResponseStructure(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
}
