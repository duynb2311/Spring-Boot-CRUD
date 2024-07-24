package com.duynb.spring.crud.controller;

import com.duynb.spring.crud.authentication.CustomUserDetails;
import com.duynb.spring.crud.authentication.JwtTokenProvider;
import com.duynb.spring.crud.dto.LoginRequestDto;
import com.duynb.spring.crud.dto.response.LoginResponseDto;
import com.duynb.spring.crud.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/auth")
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public LoginResponseDto authenticateUser(@Valid @RequestBody LoginRequestDto loginRequest) {
        return userService.authenticateUser(loginRequest);
    }
}
