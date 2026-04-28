package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SaleRepository extends JpaRepository<Sale, UUID> {
}
