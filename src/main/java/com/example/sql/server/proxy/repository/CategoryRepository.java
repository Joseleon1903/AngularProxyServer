package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CategoryRepository extends CrudRepository<Category, UUID> {
}
