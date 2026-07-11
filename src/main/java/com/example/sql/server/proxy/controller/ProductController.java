package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.domain.Product;
import com.example.sql.server.proxy.request.ProductRequest;
import com.example.sql.server.proxy.service.ProductService;
import com.example.sql.server.proxy.utils.CommonsUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductRequest product) {
        System.out.println(product);
        if(!CommonsUtils.isValidId(product.getProductId())){
            System.out.println("id producto empty creando nuevo producto");
            return ResponseEntity.ok(service.create(product));
        }
        System.out.println("actualizando producto");
        return ResponseEntity.ok(service.update(product.getProductId(), product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody ProductRequest product) {
        return ResponseEntity.ok(service.update(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        System.out.println("Entring in delete product");
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}