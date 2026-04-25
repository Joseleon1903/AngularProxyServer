package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.domain.Recipe;
import com.example.sql.server.proxy.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    // ✅ Crear
    @PostMapping
    public Recipe create(@RequestBody Recipe recipe) {
        return service.create(recipe);
    }

    // 📋 Listar
    @GetMapping
    public List<Recipe> findAll() {
        return service.findAll();
    }

    // 🔍 Obtener por id
    @GetMapping("/{id}")
    public Recipe findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    // ✏️ Actualizar
    @PutMapping("/{id}")
    public Recipe update(@PathVariable UUID id, @RequestBody Recipe recipe) {
        return service.update(id, recipe);
    }

    // ❌ Eliminar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

}