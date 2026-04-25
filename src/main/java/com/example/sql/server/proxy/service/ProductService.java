package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Product;
import com.example.sql.server.proxy.request.ProductCreationRequest;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<Product> findAll();

    Product findById(UUID id);

    Product create(ProductCreationRequest product);

    Product update(UUID id, Product product);

    void delete(UUID id);

}
