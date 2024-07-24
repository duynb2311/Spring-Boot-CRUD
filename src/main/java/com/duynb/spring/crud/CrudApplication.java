package com.duynb.spring.crud;

import com.duynb.spring.crud.entity.User;
import com.duynb.spring.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties
public class CrudApplication implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		User duy = new User();
		duy.setId(1);
		duy.setUsername("duy");
		duy.setPassword(passwordEncoder.encode("1234"));
		duy.setRole("ADMIN");
		userRepository.save(duy);

		User user = new User();
		user.setId(2);
		user.setUsername("user");
		user.setPassword(passwordEncoder.encode("1234"));
		user.setRole("USER");
		userRepository.save(user);
	}
}
