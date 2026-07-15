package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Sale;
import com.example.sql.server.proxy.request.CreateSaleRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SaleService {

    List<Sale> findAll();

    public Optional<Sale> findById(Long id);

    public Sale save(Sale sale);

    public Sale update(Long id, Sale sale);

    public void delete(Long id);

    Sale createSale(CreateSaleRequest saleRequest);
}
