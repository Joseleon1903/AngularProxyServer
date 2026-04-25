package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.domain.ProductImage;
import com.example.sql.server.proxy.service.ProductImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/products/image")
public class ProductImageController {

    private final ProductImageService service;

    public ProductImageController(ProductImageService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ProductImage uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path path = Paths.get("uploads/" + fileName);

            ProductImage img = new ProductImage();
            img.setImage(file.getBytes());
            img.setName(String.valueOf(path.getFileName()));
            img = service.uploadImage(img);

//            Files.createDirectories(path.getParent());
//            Files.write(path, file.getBytes());

            // URL que luego guardarás en Product
            return ResponseEntity.ok(img).getBody();

        } catch (Exception e) {
            throw new RuntimeException("Error uploading file");
        }
    }

    @GetMapping("/upload")
    public ResponseEntity<byte[]> uploadImage(@RequestParam("filename") String filename) {
        try {

            ProductImage img = service.getImageByName(filename);

            // URL que luego guardarás en Product
            return ResponseEntity.ok()
                    .header("Content-Type", "image/jpeg")
                    .body(img.getImage());

        } catch (Exception e) {
            throw new RuntimeException("Error uploading file");
        }
    }

}
