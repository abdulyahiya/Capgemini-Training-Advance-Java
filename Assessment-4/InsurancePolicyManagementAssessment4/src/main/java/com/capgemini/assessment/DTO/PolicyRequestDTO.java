/**
 * 
 */
package com.capgemini.assessment.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

/**
 * 
 */
@Data
public class PolicyRequestDTO {
    @NotBlank
    private String policyNumber;

    private String policyType;

    @Positive
    private double premiumAmount;

    @Positive
    private double coverageAmount;

    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;

    private Long customerId;

}
