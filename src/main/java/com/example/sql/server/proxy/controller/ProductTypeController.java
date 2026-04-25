package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.domain.ProductType;
import com.example.sql.server.proxy.service.ProductTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-types")
public class ProductTypeController {

    private final ProductTypeService service;

    public ProductTypeController(ProductTypeService service) {
        this.service = service;
    }

    // ============================
    // GET ALL
    // ============================
    @GetMapping
    public ResponseEntity<List<ProductType>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // ============================
    // GET BY ID
    // ============================
    @GetMapping("/{id}")
    public ResponseEntity<ProductType> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // ============================
    // CREATE
    // ============================
    @PostMapping
    public ResponseEntity<ProductType> create(@RequestBody ProductType productType) {
        return ResponseEntity.ok(service.create(productType));
    }

    // ============================
    // UPDATE
    // ============================
    @PutMapping("/{id}")
    public ResponseEntity<ProductType> update(
            @PathVariable UUID id,
            @RequestBody ProductType productType) {
        return ResponseEntity.ok(service.update(id, productType));
    }

    // ============================
    // DELETE (SOFT DELETE)
    // ============================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
