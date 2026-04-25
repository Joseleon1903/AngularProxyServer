package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.IngredientImage;
import com.example.sql.server.proxy.domain.RecipeImage;

public interface RecipeImageService {

    RecipeImage uploadRecipeImage(RecipeImage image);

    RecipeImage getRecipeImageByName(String name);

    IngredientImage uploadIngredientImage(IngredientImage image);

    IngredientImage getIngredientImageByName(String name);


}
