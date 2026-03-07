/**
 * 
 */
package com.capgemini.assessment.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

/**
 * 
 */
@Data
public class PolicyResponseDTO {
	private Long id;
    private String policyNumber;
    private String policyType;
    private double premiumAmount;
    private double coverageAmount;

    private LocalDate startDate;
    private LocalDate endDate;

    private String status;

    private CustomerResponseDTO customer;

}
