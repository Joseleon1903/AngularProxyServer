package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.CustomerPhysical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPhysicalRepository extends JpaRepository<CustomerPhysical, Integer> {
}
