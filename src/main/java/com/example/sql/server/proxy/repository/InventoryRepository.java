package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
