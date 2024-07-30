package com.duynb.spring.crud.dto;

import lombok.Data;

import java.security.PrivateKey;
public class LoginReponse {
    private String token;

    public LoginReponse(String token) {
        this.token = token;
    }

    public LoginReponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
