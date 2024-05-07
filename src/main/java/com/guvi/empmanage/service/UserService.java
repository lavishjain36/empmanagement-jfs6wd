package com.guvi.empmanage.service;

import com.guvi.empmanage.dto.UserRegistrationDto;
import com.guvi.empmanage.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

//configuration
public interface UserService  extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
