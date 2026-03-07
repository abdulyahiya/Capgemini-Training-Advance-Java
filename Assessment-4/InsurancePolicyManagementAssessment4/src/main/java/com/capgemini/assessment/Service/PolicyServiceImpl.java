/**
 * 
 */
package com.capgemini.assessment.Service;

/**
 * 
 */

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.capgemini.assessment.DTO.PolicyRequestDTO;
import com.capgemini.assessment.DTO.PolicyResponseDTO;
import com.capgemini.assessment.Entity.Customer;
import com.capgemini.assessment.Entity.Policy;
import com.capgemini.assessment.Mapper.PolicyMapper;
import com.capgemini.assessment.Repository.CustomerRepository;
import com.capgemini.assessment.Repository.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Policy policy = new Policy();

        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());
        policy.setStatus("ACTIVE");
        policy.setCustomer(customer);

        Policy saved = policyRepository.save(policy);

        return PolicyMapper.toDTO(saved);
    }

    @Override
    public PolicyResponseDTO getPolicyById(Long id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        return PolicyMapper.toDTO(policy);
    }

    @Override
    public Page<PolicyResponseDTO> getPolicies(Pageable pageable) {

        Page<Policy> policies = policyRepository.findAll(pageable);

        return policies.map(PolicyMapper::toDTO);
    }

    @Override
    public PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());

        Policy updated = policyRepository.save(policy);

        return PolicyMapper.toDTO(updated);
    }

    @Override
    public void cancelPolicy(Long id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        policy.setStatus("CANCELLED");

        policyRepository.save(policy);
    }

    @Override
    public List<PolicyResponseDTO> getPoliciesByType(String type) {

        return policyRepository.findByPolicyType(type)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PolicyResponseDTO> getPoliciesByPremiumRange(double min, double max) {

        return policyRepository.findByPremiumAmountBetween(min, max)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }
}