package com.duynb.spring.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseStructure <T> {
    private int statusCode;
    private String message;
    private T data;
}
