package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Product;
import com.example.sql.server.proxy.request.ProductRequest;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

    Product create(ProductRequest product);

    Product update(Long id, ProductRequest product);

    void delete(Long id);

}
