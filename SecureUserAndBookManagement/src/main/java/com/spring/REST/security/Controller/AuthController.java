/**
 * 
 */
package com.spring.REST.security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.REST.security.DTO.AuthResponse;
import com.spring.REST.security.DTO.LoginRequest;
import com.spring.REST.security.DTO.RegisterRequest;
import com.spring.REST.security.Model.User;
import com.spring.REST.security.Security.JwtUtil;
import com.spring.REST.security.Service.UserService;

/**
 * 
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {

        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());

        return userService.registerUser(user);
    }


    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request){

        String token = jwtUtil.generateToken(request.getUsername());

        return new AuthResponse(token);
    }
}
