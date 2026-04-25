package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.ProductImage;
import com.example.sql.server.proxy.repository.ProductImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService{

    private final ProductImageRepository productImageRepository;

    public ProductImageServiceImpl(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    @Override
    public ProductImage uploadImage(ProductImage image) {
        return productImageRepository.save(image);
    }

    @Override
    public ProductImage getImageByName(String name) {
        return productImageRepository.getByName(name);
    }
}
