package com.duynb.spring.crud.dto;

import lombok.Data;

import java.util.SplittableRandom;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
