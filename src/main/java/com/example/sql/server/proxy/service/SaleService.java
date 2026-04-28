package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Sale;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SaleService {

    List<Sale> findAll();

    public Optional<Sale> findById(UUID id);

    public Sale save(Sale sale);

    public Sale update(UUID id, Sale sale);

    public void delete(UUID id);
}
