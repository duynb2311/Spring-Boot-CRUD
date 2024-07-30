package com.duynb.spring.crud.service;

import com.duynb.spring.crud.Authencation.CustomUserDetail;
import com.duynb.spring.crud.constant.ConfigConstants;
import com.duynb.spring.crud.entity.Account;
import com.duynb.spring.crud.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IAccountRepository iAccountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (Objects.isNull(username)) {
            throw new IllegalArgumentException();
        }
        Account user = iAccountRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("USER_NOT_FOUND_MESSAGE");
        }
        return new CustomUserDetail(user);
    }
    @Transactional
    public UserDetails loadUserById(Integer id){
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException();
        }
        Account user = iAccountRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("USER_NOT_FOUND_MESSAGE")
        );
        return new CustomUserDetail(user);
    }
}
