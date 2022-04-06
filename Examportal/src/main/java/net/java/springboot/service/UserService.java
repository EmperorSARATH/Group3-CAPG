package net.java.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.java.springboot.model.User;
import net.java.springboot.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
