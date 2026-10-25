package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Customer;
import com.example.sql.server.proxy.domain.CustomerMoral;
import com.example.sql.server.proxy.domain.CustomerPhysical;
import com.example.sql.server.proxy.domain.CustomerType;
import com.example.sql.server.proxy.dto.CustomerRequestDTO;
import com.example.sql.server.proxy.dto.CustomerResponseDTO;
import com.example.sql.server.proxy.repository.CustomerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<CustomerResponseDTO> findAll(Integer from,Integer to) {
        if(from == null){
            from = 0;
            to = 100;
        }
        Pageable pageable = PageRequest.of(
                from,
                to
        );

        return customerRepository.findAll(pageable)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public CustomerResponseDTO findById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        return mapToDTO(customer);
    }

    @Override
    public CustomerResponseDTO updateCustomer(CustomerRequestDTO dto) {
        System.out.println("entering in updateCustomer");
        System.out.println("CustomerRequestDTO: " + dto);
        Customer cus = customerRepository.findById(dto.getId()).get();

        cus.setEmail(dto.getEmail());
        cus.setPhone(dto.getPhone());

        if(cus.getCustomerType().equals(CustomerType.F)){
            CustomerPhysical fisiPhysical = (CustomerPhysical) cus;
            fisiPhysical.setFirstName(dto.getFirstName());
            fisiPhysical.setIdentificationNumber(dto.getIdentificationNumber());
            fisiPhysical.setLastName(dto.getLastName());
        }else{
            CustomerMoral moralPhysical = (CustomerMoral) cus;
            moralPhysical.setBusinessName(dto.getBusinessName());
            moralPhysical.setRnc(dto.getRnc());
        }
        System.out.println("Customer entity: " + cus);
        Customer entity =  customerRepository.save(cus);
        CustomerResponseDTO dtoResponse = mapToDTO(entity);
        System.out.println("reponse: "+dtoResponse);
        return dtoResponse;
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
