package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductImageRepository extends JpaRepository<ProductImage, UUID> {

    ProductImage getByName(String name);
}
