package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.domain.Unit;
import com.example.sql.server.proxy.service.UnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/units")
public class UnitController {

    private final UnitService service;

    public UnitController(UnitService service) {
        this.service = service;
    }

    // ============================
    // GET ALL
    // ============================
    @GetMapping
    public ResponseEntity<List<Unit>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // ============================
    // GET BY ID
    // ============================
    @GetMapping("/{id}")
    public ResponseEntity<Unit> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // ============================
    // CREATE
    // ============================
    @PostMapping
    public ResponseEntity<Unit> create(@RequestBody Unit unit) {
        return ResponseEntity.ok(service.create(unit));
    }

    // ============================
    // UPDATE
    // ============================
    @PutMapping("/{id}")
    public ResponseEntity<Unit> update(
            @PathVariable UUID id,
            @RequestBody Unit unit) {
        return ResponseEntity.ok(service.update(id, unit));
    }

    // ============================
    // DELETE
    // ============================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
