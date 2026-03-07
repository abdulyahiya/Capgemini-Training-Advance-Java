package com.capgemini.assessment.Service;

import java.util.List;

import com.capgemini.assessment.DTO.CustomerRequestDTO;
import com.capgemini.assessment.DTO.CustomerResponseDTO;

public interface CustomerService {

    CustomerResponseDTO createCustomer(CustomerRequestDTO dto);

    List<CustomerResponseDTO> getAllCustomers();

    CustomerResponseDTO getCustomerById(Long id);
}