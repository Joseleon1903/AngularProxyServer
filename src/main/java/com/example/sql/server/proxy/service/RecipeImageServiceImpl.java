package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.IngredientImage;
import com.example.sql.server.proxy.domain.RecipeImage;
import com.example.sql.server.proxy.repository.IngredientImageRepository;
import com.example.sql.server.proxy.repository.RecipeImageRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeImageServiceImpl implements RecipeImageService{

    private final RecipeImageRepository recipeImageRepository;

    private final IngredientImageRepository ingredientImageRepository;

    public RecipeImageServiceImpl(RecipeImageRepository recipeImageRepository, IngredientImageRepository ingredientImageRepository) {
        this.recipeImageRepository = recipeImageRepository;
        this.ingredientImageRepository = ingredientImageRepository;
    }

    @Override
    public RecipeImage uploadRecipeImage(RecipeImage image) {
        return recipeImageRepository.save(image);
    }

    @Override
    public RecipeImage getRecipeImageByName(String name) {
        return recipeImageRepository.getByName(name);
    }

    @Override
    public IngredientImage uploadIngredientImage(IngredientImage image) {
        return ingredientImageRepository.save(image);
    }

    @Override
    public IngredientImage getIngredientImageByName(String name) {
        return ingredientImageRepository.findByName(name);
    }
}
