/**
 * 
 */
package com.capgemini.assessment.Mapper;

import com.capgemini.assessment.DTO.PolicyResponseDTO;
import com.capgemini.assessment.Entity.Policy;

/**
 * 
 */
public class PolicyMapper {

    public static PolicyResponseDTO toDTO(Policy p) {

        PolicyResponseDTO dto = new PolicyResponseDTO();

        dto.setId(p.getId());
        dto.setPolicyNumber(p.getPolicyNumber());
        dto.setPolicyType(p.getPolicyType());
        dto.setPremiumAmount(p.getPremiumAmount());
        dto.setCoverageAmount(p.getCoverageAmount());
        dto.setStartDate(p.getStartDate());
        dto.setEndDate(p.getEndDate());
        dto.setStatus(p.getStatus());

        dto.setCustomer(CustomerMapper.toDTO(p.getCustomer()));

        return dto;
}
}
