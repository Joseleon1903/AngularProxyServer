package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.dto.CustomerRequestDTO;
import com.example.sql.server.proxy.dto.CustomerResponseDTO;
import com.example.sql.server.proxy.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public CustomerResponseDTO create(@RequestBody CustomerRequestDTO dto) {
        return customerService.create(dto);
    }

    @GetMapping
    public List<CustomerResponseDTO> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO findById(@PathVariable Long id) {
        return customerService.findById(id);
    }
}
