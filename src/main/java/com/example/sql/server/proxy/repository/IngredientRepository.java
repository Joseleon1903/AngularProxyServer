package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
