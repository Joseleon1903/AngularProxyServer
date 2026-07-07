package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
