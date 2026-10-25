package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Inventory;
import com.example.sql.server.proxy.domain.Product;
import com.example.sql.server.proxy.repository.CategoryRepository;
import com.example.sql.server.proxy.repository.ProductRepository;
import com.example.sql.server.proxy.repository.ProductTypeRepository;
import com.example.sql.server.proxy.request.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final ProductTypeRepository productTypeRepository;


    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository,
                              ProductTypeRepository productTypeRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productTypeRepository= productTypeRepository;
    }

    @Override
    public List<Product> findAll(Integer from, Integer to) {
        List<Product> respuesta =  new ArrayList<>();
        if(from == null){
            from = 0;
            to = 100;
        }
        Pageable pageable = PageRequest.of(
                from,
                to
        );
        System.out.println("pageable: "+pageable);
        Page<Product> resPaginada = productRepository.findAll(pageable);
        resPaginada.forEach(respuesta::add);
        return respuesta;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product create(ProductRequest productInput) {
        System.out.println("product: "+productInput);
        Product product = new Product();
//        product.setId(UUID.randomUUID());
        product.setTenantId(UUID.randomUUID());
        product.setCreatedAtUtc(LocalDateTime.now());
        product.setUpdatedAtUtc(LocalDateTime.now());
        product.setDeleted(false);

        product.setCategoryId(categoryRepository.findById(productInput.getCategoryId()).get());

        product.setProductTypeId(productTypeRepository.findById(productInput.getProductTypeId()).get());

        product.setName(productInput.getName());
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
    public Product update(Long id, ProductRequest product) {
        Product existing = findById(id);

        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPriceAmount(product.getPriceAmount());
        existing.setPriceCurrency(product.getPriceCurrency());
        existing.setProductionCostAmount(product.getProductionCostAmount());
        existing.setProductionCostCurrency(product.getProductionCostCurrency());

        existing.setCategoryId(categoryRepository.findById(product.getCategoryId()).get());

        existing.setProductTypeId(productTypeRepository.findById(product.getProductTypeId()).get());
        existing.setImageUrl(product.getImageUrl());
        existing.setActive(product.isActive());
        existing.setUpdatedAtUtc(LocalDateTime.now());

        return productRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Product existing = findById(id);

//        // 🔥 Soft delete
//        existing.setDeleted(true);
//        existing.setDeletedAtUtc(LocalDateTime.now());

        productRepository.delete(existing);
    }
}