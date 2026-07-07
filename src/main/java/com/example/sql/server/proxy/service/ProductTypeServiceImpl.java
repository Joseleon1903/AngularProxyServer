package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.ProductType;
import com.example.sql.server.proxy.repository.ProductTypeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    private final ProductTypeRepository repository;

    public ProductTypeServiceImpl(ProductTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductType> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductType findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductType not found"));
    }

    @Override
    public ProductType create(ProductType productType) {
//        productType.setId(UUID.randomUUID());
        productType.setCreatedAtUtc(LocalDateTime.now());
        productType.setUpdatedAtUtc(LocalDateTime.now());
        productType.setIsDeleted(false);

        return repository.save(productType);
    }

    @Override
    public ProductType update(Long id, ProductType productType) {
        ProductType existing = findById(id);

        existing.setName(productType.getName());
        existing.setDescription(productType.getDescription());
        existing.setIsActive(productType.getIsActive());
        existing.setIsDefault(productType.getIsDefault());
        existing.setUpdatedAtUtc(LocalDateTime.now());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        ProductType existing = findById(id);

        // 🔥 Soft delete
        existing.setIsDeleted(true);
        existing.setDeletedAtUtc(LocalDateTime.now());

        repository.save(existing);
    }
}
