package com.duynb.spring.crud.service;

import com.duynb.spring.crud.authentication.CustomUserDetails;
import com.duynb.spring.crud.authentication.JwtTokenProvider;
import com.duynb.spring.crud.constant.ConfigConstants;
import com.duynb.spring.crud.dto.LoginRequestDto;
import com.duynb.spring.crud.dto.response.LoginResponseDto;
import com.duynb.spring.crud.entity.User;
import com.duynb.spring.crud.exception.NotFoundException;
import com.duynb.spring.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Tìm kiếm tài khoản bằng username
     * @param username tên tài khoản
     * @return đối tượng user đã được custom phù hợp với spring security
     */
    @Override
    public CustomUserDetails loadUserByUsername(String username){
        if(Objects.isNull(username)){
            throw new IllegalArgumentException();
        }
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new NotFoundException(ConfigConstants.USER_NOT_FOUND_MESSAGE);
        }
        return new CustomUserDetails(user);
    }

    /**
     * tìm kiếm tài khoản bằng id
     * @param id id tài khoản
     * @return đối tượng user đã được custom phù hợp với spring security
     */
    @Transactional
    public UserDetails loadUserById(Integer id) {
        if(Objects.isNull(id)){
            throw new IllegalArgumentException();
        }
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException(ConfigConstants.USER_NOT_FOUND_MESSAGE)
        );

        return new CustomUserDetails(user);
    }

    /**
     * Phương thức xác thực login tài khoản người dùng
     * @param loginRequest dối tượng request chứa tài khoản mật khẩu
     * @return chuỗi jwt
     */
    public LoginResponseDto authenticateUser(LoginRequestDto loginRequest) {
        if (Objects.isNull(loginRequest)){
            throw new IllegalArgumentException();
        }

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        System.out.println(authentication.getAuthorities());

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponseDto(jwt);
    }
}
