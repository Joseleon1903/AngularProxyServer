package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
