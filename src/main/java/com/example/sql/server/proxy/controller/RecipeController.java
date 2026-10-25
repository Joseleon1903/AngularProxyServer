package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.domain.Recipe;
import com.example.sql.server.proxy.dto.RecipeResponseDTO;
import com.example.sql.server.proxy.service.RecipeService;
import com.example.sql.server.proxy.utils.RecipeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<RecipeResponseDTO> findPaginated(@RequestParam(value = "from", required = false) Integer from,
                                                 @RequestParam(value = "to",required = false) Integer to) {

        List<RecipeResponseDTO> response = RecipeUtils.toList(service.findAll(from, to));
        return response;
    }



    // 🔍 Obtener por id
    @GetMapping("/{id}")
    public Recipe findById(@PathVariable Long id) {
        return service.findById(id);
    }

    // ✏️ Actualizar
    @PutMapping("/{id}")
    public Recipe update(@PathVariable Long id, @RequestBody Recipe recipe) {
        return service.update(id, recipe);
    }

    // ❌ Eliminar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}