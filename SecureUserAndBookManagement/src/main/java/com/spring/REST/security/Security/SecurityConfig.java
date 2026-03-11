/**
 * 
 */
package com.spring.REST.security.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
        .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                    .requestMatchers("/api/auth/**").permitAll()

                    .requestMatchers(HttpMethod.POST,"/api/books").hasRole("ADMIN")

                    .requestMatchers(HttpMethod.PUT,"/api/books/**").hasRole("ADMIN")

                    .requestMatchers(HttpMethod.DELETE,"/api/books/**").hasRole("ADMIN")

                    .requestMatchers(HttpMethod.GET,"/api/books/**")
                    .hasAnyRole("ADMIN","USER")

                    .anyRequest().authenticated()
            )
            .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
