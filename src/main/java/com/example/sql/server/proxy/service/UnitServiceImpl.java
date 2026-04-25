package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Unit;
import com.example.sql.server.proxy.repository.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UnitServiceImpl  implements UnitService{

    private final UnitRepository repository;

    public UnitServiceImpl(UnitRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Unit> findAll() {
        return (List<Unit>) repository.findAll();
    }

    @Override
    public Unit findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found"));
    }

    @Override
    public Unit create(Unit unit) {
        unit.setId(UUID.randomUUID());
        return repository.save(unit);
    }

    @Override
    public Unit update(UUID id, Unit unit) {
        Unit existing = findById(id);

        existing.setCode(unit.getCode());
        existing.setName(unit.getName());
        existing.setUnitType(unit.getUnitType());
        existing.setConversionFactorToBase(unit.getConversionFactorToBase());
        existing.setIsBaseUnit(unit.getIsBaseUnit());

        return repository.save(existing);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Unit not found");
        }

        repository.deleteById(id);
    }
}