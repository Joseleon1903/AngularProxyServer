package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UnitRepository extends CrudRepository<Unit, UUID> {
}
