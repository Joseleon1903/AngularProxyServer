package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Category;
import com.example.sql.server.proxy.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    @Override
    public Category findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public Category create(Category category) {
        category.setId(UUID.randomUUID());
        category.setCreatedAtUtc(LocalDateTime.now());
        category.setUpdatedAtUtc(LocalDateTime.now());
        category.setIsDeleted(false);

        return repository.save(category);
    }

    @Override
    public Category update(UUID id, Category category) {
        Category existing = findById(id);

        existing.setName(category.getName());
        existing.setDescription(category.getDescription());
        existing.setIsActive(category.getIsActive());
        existing.setUpdatedAtUtc(LocalDateTime.now());

        return repository.save(existing);
    }

    @Override
    public void delete(UUID id) {
        Category existing = findById(id);

        // 🔥 Soft Delete
        existing.setIsDeleted(true);
        existing.setDeletedAtUtc(LocalDateTime.now());

        repository.save(existing);

        // ❗ Si quieres delete físico usa:
        // repository.deleteById(id);
    }


}
