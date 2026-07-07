package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Category;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface CategoryService {

    Set<Category> findAll();

    Category findById(Long id);

    Category create(Category category);

    Category update(Long id, Category category);

    void delete(Long id);


}
