package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.domain.Category;
import com.example.sql.server.proxy.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    // ============================
    // GET ALL
    // ============================
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // ============================
    // GET BY ID
    // ============================
    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // ============================
    // CREATE
    // ============================
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return ResponseEntity.ok(service.create(category));
    }

    // ============================
    // UPDATE
    // ============================
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(
            @PathVariable UUID id,
            @RequestBody Category category) {
        return ResponseEntity.ok(service.update(id, category));
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
