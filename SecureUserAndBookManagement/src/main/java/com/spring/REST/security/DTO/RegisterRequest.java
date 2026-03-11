/**
 * 
 */
package com.spring.REST.security.DTO;

import lombok.Data;

/**
 * 
 */

@Data
public class RegisterRequest {

    private String username;
    private String password;
    private String email;
    private String role;

    // getters and setters
}
