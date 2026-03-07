/**
 * 
 */
package com.capgemini.assessment.Service;

import org.springframework.data.domain.Pageable; 
import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.assessment.DTO.PolicyRequestDTO;
import com.capgemini.assessment.DTO.PolicyResponseDTO;

/**
 * 
 */
public interface PolicyService {
	PolicyResponseDTO createPolicy(PolicyRequestDTO dto);

    PolicyResponseDTO getPolicyById(Long id);
    Page<PolicyResponseDTO> getPolicies(Pageable pageable);

    PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto);

    void cancelPolicy(Long id);

    List<PolicyResponseDTO> getPoliciesByType(String type);

    List<PolicyResponseDTO> getPoliciesByPremiumRange(double min, double max);
}
