package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
