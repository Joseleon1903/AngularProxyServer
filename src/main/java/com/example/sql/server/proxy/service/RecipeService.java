package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Recipe;

import java.util.List;
import java.util.UUID;

public interface RecipeService {


    // ✅ Crear receta con ingredientes
    public Recipe create(Recipe recipe)
    ;
    // 📋 Listar todas
    public List<Recipe> findAll();

    // 🔍 Buscar por id
    public Recipe findById(UUID id);

    // ✏️ Actualizar
    public Recipe update(UUID id, Recipe updated);

    // ❌ Eliminar
    public void delete(UUID id);
}
