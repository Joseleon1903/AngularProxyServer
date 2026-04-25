package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
}
