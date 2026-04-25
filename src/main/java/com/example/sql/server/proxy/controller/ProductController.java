package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.domain.Product;
import com.example.sql.server.proxy.request.ProductCreationRequest;
import com.example.sql.server.proxy.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductCreationRequest product) {
        System.out.println(product);
        return ResponseEntity.ok(service.create(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable UUID id, @RequestBody Product product) {
        return ResponseEntity.ok(service.update(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        System.out.println("Entring in delete product");
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}