package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
