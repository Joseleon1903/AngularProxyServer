package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.dto.CustomerRequestDTO;
import com.example.sql.server.proxy.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {

    CustomerResponseDTO create(CustomerRequestDTO dto);

    List<CustomerResponseDTO> findAll();

    CustomerResponseDTO findById(Long id);

}
