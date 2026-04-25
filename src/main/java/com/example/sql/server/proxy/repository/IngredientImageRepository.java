package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.IngredientImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IngredientImageRepository extends JpaRepository<IngredientImage, UUID> {

    IngredientImage findByName(String name);

}
