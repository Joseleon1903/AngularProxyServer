package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Sale;
import com.example.sql.server.proxy.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SaleServiceImpl implements SaleService{

    private final SaleRepository repository;

    public SaleServiceImpl(SaleRepository repository) {
        this.repository = repository;
    }

    // Obtener todas las ventas
    public List<Sale> findAll() {
        return repository.findAll();
    }

    // Obtener por ID
    public Optional<Sale> findById(UUID id) {
        return repository.findById(id);
    }

    // Crear venta
    public Sale save(Sale sale) {
        sale.setCreatedAt(LocalDateTime.now());
        return repository.save(sale);
    }

    // Actualizar venta
    public Sale update(UUID id, Sale sale) {
        Sale existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found"));

        existing.setSaleDate(sale.getSaleDate());
        existing.setReferenceNumber(sale.getReferenceNumber());
        existing.setCustomerName(sale.getCustomerName());
        existing.setProductDescription(sale.getProductDescription());
        existing.setQuantity(sale.getQuantity());
        existing.setUnitPrice(sale.getUnitPrice());
        existing.setPaymentMethod(sale.getPaymentMethod());

        return repository.save(existing);
    }

    // Eliminar venta
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
