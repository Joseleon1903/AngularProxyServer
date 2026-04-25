package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Unit;

import java.util.List;
import java.util.UUID;

public interface UnitService {

    List<Unit> findAll();

    Unit findById(UUID id);

    Unit create(Unit unit);

    Unit update(UUID id, Unit unit);

    void delete(UUID id);


}
