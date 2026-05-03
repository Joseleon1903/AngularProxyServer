package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Product;
import com.example.sql.server.proxy.repository.CategoryRepository;
import com.example.sql.server.proxy.repository.ProductRepository;
import com.example.sql.server.proxy.repository.ProductTypeRepository;
import com.example.sql.server.proxy.request.ProductRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository,
                              ProductTypeRepository productTypeRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product create(ProductRequest productInput) {
        System.out.println("product: "+productInput);
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setTenantId(UUID.randomUUID());
        product.setCreatedAtUtc(LocalDateTime.now());
        product.setUpdatedAtUtc(LocalDateTime.now());
        product.setDeleted(false);

        product.setCategoryId(UUID.fromString(productInput.getCategoryId()));
        product.setProductTypeId(UUID.fromString(productInput.getProductTypeId()));
        product.setName(productInput.getName());
        product.setUnitId(UUID.fromString("DFC86DA2-E1B9-4182-563B-08DE931F0025"));
        product.setUnitType(1);
        product.setDescription(productInput.getDescription());
        product.setPriceAmount(productInput.getPriceAmount());
        product.setPriceCurrency(productInput.getPriceCurrency());
        product.setProductionCostAmount(productInput.getProductionCostAmount());
        product.setProductionCostCurrency(productInput.getProductionCostCurrency());
        product.setActive(true);

        product.setImageUrl(productInput.getImageUrl());

        System.out.println("Entiry : "+ product);
        return productRepository.save(product);
    }

    @Override
    public Product update(UUID id, ProductRequest product) {
        Product existing = findById(id);

        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPriceAmount(product.getPriceAmount());
        existing.setPriceCurrency(product.getPriceCurrency());
        existing.setProductionCostAmount(product.getProductionCostAmount());
        existing.setProductionCostCurrency(product.getProductionCostCurrency());

        existing.setCategoryId(UUID.fromString(product.getCategoryId()));
        existing.setProductTypeId(UUID.fromString(product.getProductTypeId()));
//        existing.setUnitId(UUID.fromString(product.getUnitId()));
        existing.setUnitType(product.getUnitType());
        existing.setImageUrl(product.getImageUrl());
        existing.setActive(product.isActive());
        existing.setUpdatedAtUtc(LocalDateTime.now());

        return productRepository.save(existing);
    }

    @Override
    public void delete(UUID id) {
        Product existing = findById(id);

//        // 🔥 Soft delete
//        existing.setDeleted(true);
//        existing.setDeletedAtUtc(LocalDateTime.now());

        productRepository.delete(existing);
    }
}