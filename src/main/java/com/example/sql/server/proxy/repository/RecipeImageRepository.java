package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.RecipeImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeImageRepository extends JpaRepository<RecipeImage, UUID> {

    RecipeImage getByName(String name);

}
