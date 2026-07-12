package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Recipe;
import com.example.sql.server.proxy.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    // ✅ Crear receta con ingredientes
    public Recipe create(Recipe recipe) {
        recipe = recipeRepository.save(recipe);
        System.out.println("save: "+recipe);
        return recipe;
    }

    // 📋 Listar todas
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    // 🔍 Buscar por id
    public Recipe findById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
    }

    // ✏️ Actualizar
    public Recipe update(Long id, Recipe updated) {
        Recipe existing = findById(id);

        existing.setName(updated.getName());
        existing.setImageUrl(updated.getImageUrl());
        existing.setTag(updated.getTag());
        existing.setPrepTime(updated.getPrepTime());
        existing.setCookingTime(updated.getCookingTime());
        existing.setYield(updated.getYield());
        existing.setDifficulty(updated.getDifficulty());

        // actualizar ingredientes y preparetion steps
        existing.getIngredients().clear();
        existing.getIngredients().addAll(updated.getIngredients());

        existing.getPreparationSteps().clear();
        existing.getPreparationSteps().addAll(updated.getPreparationSteps());

        return recipeRepository.save(existing);
    }

    // ❌ Eliminar
    public void delete(Long id) {
        recipeRepository.deleteById(id);
    }
}
