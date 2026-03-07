/**
 * 
 */
package com.capgemini.assessment.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 
 */
@Data
public class CustomerRequestDTO {
	 @NotBlank
	 private String name;

	 @Email
	 private String email;

	 private String phoneNumber;
	 private String address;

}
