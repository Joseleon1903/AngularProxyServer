package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Recipe;
import com.example.sql.server.proxy.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    // ✅ Crear receta con ingredientes
    public Recipe create(Recipe recipe) {

        recipe.getIngredients().forEach(i -> i.setRecipe(recipe));
        // asegura relación bidireccional
        return recipeRepository.save(recipe);
    }

    // 📋 Listar todas
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    // 🔍 Buscar por id
    public Recipe findById(UUID id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
    }

    // ✏️ Actualizar
    public Recipe update(UUID id, Recipe updated) {
        Recipe existing = findById(id);

        existing.setName(updated.getName());
        existing.setImageUrl(updated.getImageUrl());
        existing.setTag(updated.getTag());
        existing.setPrepTime(updated.getPrepTime());
        existing.setYield(updated.getYield());
        existing.setDifficulty(updated.getDifficulty());

        // actualizar ingredientes


        return recipeRepository.save(existing);
    }

    // ❌ Eliminar
    public void delete(UUID id) {
        recipeRepository.deleteById(id);
    }
}
