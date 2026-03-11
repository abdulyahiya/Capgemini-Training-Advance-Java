/**
 * 
 */
package com.spring.REST.security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.REST.security.Model.User;
import com.spring.REST.security.Repository.UserRepository;

import lombok.Data;

/**
 * 
 */
@Service
@Data
public class UserService {
	  @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    public User registerUser(User user) {

	        user.setPassword(passwordEncoder.encode(user.getPassword()));

	        return userRepository.save(user);
	    }

}
