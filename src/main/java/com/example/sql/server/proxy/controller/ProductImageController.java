package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.domain.IngredientImage;
import com.example.sql.server.proxy.domain.ProductImage;
import com.example.sql.server.proxy.domain.RecipeImage;
import com.example.sql.server.proxy.domain.SaleAttachment;
import com.example.sql.server.proxy.service.ProductImageService;
import com.example.sql.server.proxy.service.RecipeImageService;
import com.example.sql.server.proxy.service.SaleAttachmenService;
import com.example.sql.server.proxy.utils.ImageUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/products/image")
public class ProductImageController {

    private final ProductImageService productImageService;

    private final RecipeImageService recipeImageService;

    private final SaleAttachmenService saleAttachmenService;


    public ProductImageController(ProductImageService productImageService, RecipeImageService recipeImageService, SaleAttachmenService saleAttachmenService) {
        this.productImageService = productImageService;
        this.recipeImageService = recipeImageService;
        this.saleAttachmenService = saleAttachmenService;
    }

    @PostMapping("/upload/{root}")
    public Object uploadImage(@RequestParam("file") MultipartFile file, @PathVariable("root") String root) {
        System.out.println("entering uploadImage");
        System.out.println("root: "+ root);
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path path = Paths.get("uploads/" + fileName);

            ProductImage img = new ProductImage();
            img.setImage(file.getBytes());
            img.setName(ImageUtil.generateImageName(root, "jpg"));

            RecipeImage imgRecipe = new RecipeImage();
            imgRecipe.setImage(file.getBytes());
            imgRecipe.setName(ImageUtil.generateImageName(root, "jpg"));

            IngredientImage imgIngredient = new IngredientImage();
            imgIngredient.setImage(file.getBytes());
            imgIngredient.setName(ImageUtil.generateImageName(root, "jpg"));

            SaleAttachment imgSale = new SaleAttachment();
            imgSale.setImage(file.getBytes());
            imgSale.setName(ImageUtil.generateImageName(root, "jpg"));


            switch (root) {

                // Case 1
                case "product":
                    // Print statement corresponding case
                    System.out.println("upload product");
                    img = productImageService.uploadImage(img);
                    return ResponseEntity.ok(img).getBody();

                // Case 2
                case "recipe":

                    // Print statement corresponding case
                    System.out.println("upload recipe");
                    imgRecipe = recipeImageService.uploadRecipeImage(imgRecipe);

                    return ResponseEntity.ok(imgRecipe).getBody();
                // Case 3
                case "ingredient":

                    // Print statement corresponding case
                    System.out.println("upload ingredient");
                    imgIngredient = recipeImageService.uploadIngredientImage(imgIngredient);
                    return ResponseEntity.ok(imgIngredient).getBody();

                case "sale":

                    // Print statement corresponding case
                    System.out.println("upload sale");
                    imgSale = saleAttachmenService.uploadRecipeImage(imgSale);
                    return ResponseEntity.ok(imgSale).getBody();

                // Case 4
                // Default case
                default:

                    // Print statement corresponding case
                    System.out.println("no match");
            }
            // URL que luego guardarás en Product

            return ResponseEntity.ok(img).getBody();

        } catch (Exception e) {
            throw new RuntimeException("Error uploading file"+ e.getMessage());
        }
    }

    @GetMapping("/upload/{root}")
    public ResponseEntity<byte[]> getImage(@RequestParam("filename") String filename, @PathVariable("root") String root) {
        System.out.println("entering getImage");
        System.out.println("root: "+ root);
        try {
            switch (root) {
                // Case 1
                case "product":
                    // Print statement corresponding case
                    System.out.println("get product");
                    ProductImage img = productImageService.getImageByName(filename);
                    return ResponseEntity.ok()
                            .header("Content-Type", "image/jpeg")
                            .body(img.getImage());

                // Case 2
                case "recipe":
                    // Print statement corresponding case
                    System.out.println("upload recipe");
                    RecipeImage recipeimage = recipeImageService.getRecipeImageByName(filename);

                    return ResponseEntity.ok()
                            .header("Content-Type", "image/jpeg")
                            .body(recipeimage.getImage());
                // Case 3
                case "ingredient":
                    // Print statement corresponding case
                    System.out.println("upload ingredient");
                    IngredientImage ingredientImage = recipeImageService.getIngredientImageByName(filename);
                    return ResponseEntity.ok()
                            .header("Content-Type", "image/jpeg")
                            .body(ingredientImage.getImage());

                case "sale":
                    // Print statement corresponding case
                    System.out.println("upload sale");
                    SaleAttachment saleImage = saleAttachmenService.getRecipeImageByName(filename);
                    return ResponseEntity.ok()
                            .header("Content-Type", "image/jpeg")
                            .body(saleImage.getImage());

                // Case 4
                // Default case
                default:
                    // Print statement corresponding case
                    System.out.println("no match");
            }
            // URL que luego guardarás en Product
        } catch (Exception e) {
            throw new RuntimeException("Error uploading file");
        }
        return ResponseEntity.notFound().build();
    }

}
