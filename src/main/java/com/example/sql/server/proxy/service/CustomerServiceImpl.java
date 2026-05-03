package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Customer;
import com.example.sql.server.proxy.domain.CustomerMoral;
import com.example.sql.server.proxy.domain.CustomerPhysical;
import com.example.sql.server.proxy.dto.CustomerRequestDTO;
import com.example.sql.server.proxy.dto.CustomerResponseDTO;
import com.example.sql.server.proxy.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponseDTO create(CustomerRequestDTO dto) {

        if (dto.getType().equalsIgnoreCase("F")) {

            CustomerPhysical customer = new CustomerPhysical();
            customer.setPhone(dto.getPhone());
            customer.setEmail(dto.getEmail());
            customer.setFirstName(dto.getFirstName());
            customer.setLastName(dto.getLastName());
            customer.setIdentificationNumber(dto.getIdentificationNumber());

            Customer saved = customerRepository.save(customer);

            return mapToDTO(saved);

        } else if (dto.getType().equalsIgnoreCase("M")) {

            CustomerMoral customer = new CustomerMoral();
            customer.setPhone(dto.getPhone());
            customer.setEmail(dto.getEmail());
            customer.setBusinessName(dto.getBusinessName());
            customer.setRnc(dto.getRnc());

            Customer saved = customerRepository.save(customer);

            return mapToDTO(saved);
        }

        throw new RuntimeException("Tipo de cliente inválido");
    }

    @Override
    public List<CustomerResponseDTO> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public CustomerResponseDTO findById(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        return mapToDTO(customer);
    }

    private CustomerResponseDTO mapToDTO(Customer customer) {

        if (customer instanceof CustomerPhysical physical) {
            return new CustomerResponseDTO(physical.getId(),"F",physical.getPhone(),physical.getEmail(),
                    physical.getFirstName(),physical.getLastName(),physical.getIdentificationNumber());
        }

        if (customer instanceof CustomerMoral moral) {
            return new CustomerResponseDTO(moral.getId(),"M",moral.getPhone(),moral.getEmail(),
                    moral.getBusinessName(),moral.getRnc());
        }

        throw new RuntimeException("Tipo desconocido");
    }
}
