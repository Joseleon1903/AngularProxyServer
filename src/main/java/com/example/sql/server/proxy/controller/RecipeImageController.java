package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.domain.IngredientImage;
import com.example.sql.server.proxy.domain.RecipeImage;
import com.example.sql.server.proxy.service.RecipeImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/recipe/image")
public class RecipeImageController {

    private final RecipeImageService recipeImageService;

    public RecipeImageController(RecipeImageService recipeImageService) {
        this.recipeImageService = recipeImageService;
    }

    @PostMapping("/recipeImage")
    public RecipeImage uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path path = Paths.get("uploads/" + fileName);

            RecipeImage img = new RecipeImage();
            img.setImage(file.getBytes());
            img.setName(String.valueOf(path.getFileName()));
            img = recipeImageService.uploadRecipeImage(img);

            // URL que luego guardarás en Product
            return ResponseEntity.ok(img).getBody();

        } catch (Exception e) {
            throw new RuntimeException("Error uploading file");
        }
    }

    @GetMapping("/recipeImage")
    public ResponseEntity<byte[]> uploadImage(@RequestParam("filename") String filename) {
        try {

            RecipeImage img = recipeImageService.getRecipeImageByName(filename);

            // URL que luego guardarás en Product
            return ResponseEntity.ok()
                    .header("Content-Type", "image/jpeg")
                    .body(img.getImage());

        } catch (Exception e) {
            throw new RuntimeException("Error uploading file");
        }
    }


    // ingredientes endpoint

    @PostMapping("/ingredientImage")
    public IngredientImage uploadIngredientImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path path = Paths.get("uploads/" + fileName);

            IngredientImage img = new IngredientImage();
            img.setImage(file.getBytes());
            img.setName(String.valueOf(path.getFileName()));
            img = recipeImageService.uploadIngredientImage(img);

            // URL que luego guardarás en Product
            return ResponseEntity.ok(img).getBody();

        } catch (Exception e) {
            throw new RuntimeException("Error uploading file");
        }
    }

    @GetMapping("/ingredientImage")
    public ResponseEntity<byte[]> uploadIngredientImage(@RequestParam("filename") String filename) {
        try {

            IngredientImage img = recipeImageService.getIngredientImageByName(filename);

            // URL que luego guardarás en Product
            return ResponseEntity.ok()
                    .header("Content-Type", "image/jpeg")
                    .body(img.getImage());

        } catch (Exception e) {
            throw new RuntimeException("Error uploading file");
        }
    }

}
