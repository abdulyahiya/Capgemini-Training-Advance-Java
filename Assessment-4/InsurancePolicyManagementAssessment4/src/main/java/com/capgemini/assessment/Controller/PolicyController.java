/**
 * 
 */
package com.capgemini.assessment.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.assessment.DTO.PolicyRequestDTO;
import com.capgemini.assessment.DTO.PolicyResponseDTO;
import com.capgemini.assessment.Service.PolicyService;

import jakarta.validation.Valid;

/**
 * 
 */
@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService service;

    // Create Policy
    @PostMapping
    public PolicyResponseDTO createPolicy(@RequestBody @Valid PolicyRequestDTO dto){
        return service.createPolicy(dto);
    }

    // Get Policy By ID
    @GetMapping("/{id}")
    public PolicyResponseDTO getPolicy(@PathVariable Long id){
        return service.getPolicyById(id);
    }

    // Filter by Policy Type
    @GetMapping("/type/{type}")
    public List<PolicyResponseDTO> getByType(@PathVariable String type){
        return service.getPoliciesByType(type);
    }

    // Filter by Premium Range
    @GetMapping("/premium")
    public List<PolicyResponseDTO> getByPremium(
            @RequestParam double min,
            @RequestParam double max){

        return service.getPoliciesByPremiumRange(min, max);
    }

    // Pagination + Sorting
    @GetMapping
    public Page<PolicyResponseDTO> getPolicies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "premiumAmount") String sortBy,
            @RequestParam(defaultValue = "asc") String direction){

        Pageable pageable = PageRequest.of(
                page,
                size,
                direction.equalsIgnoreCase("asc") ?
                        Sort.by(sortBy).ascending() :
                        Sort.by(sortBy).descending()
        );

        return service.getPolicies(pageable);
    }

    // Update Policy
    @PutMapping("/{id}")
    public PolicyResponseDTO updatePolicy(
            @PathVariable Long id,
            @RequestBody @Valid PolicyRequestDTO dto){

        return service.updatePolicy(id, dto);
    }

    // Cancel Policy
    @DeleteMapping("/{id}")
    public String cancelPolicy(@PathVariable Long id){

        service.cancelPolicy(id);
        return "Policy cancelled successfully";
    }

}