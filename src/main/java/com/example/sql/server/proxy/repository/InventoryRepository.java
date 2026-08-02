package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query("SELECT i FROM Inventory i WHERE i.product.id = :productId")
    Optional<List<Inventory>> findByProductId(@Param("productId") Long productId);
}
