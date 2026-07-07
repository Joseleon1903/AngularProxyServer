package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {
}