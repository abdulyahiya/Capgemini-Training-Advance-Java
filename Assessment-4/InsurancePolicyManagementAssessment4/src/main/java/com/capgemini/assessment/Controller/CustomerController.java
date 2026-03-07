/**
 * 
 */
package com.capgemini.assessment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.assessment.DTO.CustomerRequestDTO;
import com.capgemini.assessment.DTO.CustomerResponseDTO;
import com.capgemini.assessment.Service.CustomerService;

import jakarta.validation.Valid;

/**
 * 
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public CustomerResponseDTO createCustomer(@RequestBody @Valid CustomerRequestDTO dto){
        return service.createCustomer(dto);
    }

    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers(){
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable Long id){
        return service.getCustomerById(id);
    }
}
