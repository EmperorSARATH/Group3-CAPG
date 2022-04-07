package registration.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import registration.model.User;
import registration.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
