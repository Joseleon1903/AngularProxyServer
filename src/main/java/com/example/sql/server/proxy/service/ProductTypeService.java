package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.ProductType;

import java.util.List;
import java.util.UUID;

public interface ProductTypeService {


    List<ProductType> findAll();

    ProductType findById(UUID id);

    ProductType create(ProductType productType);

    ProductType update(UUID id, ProductType productType);

    void delete(UUID id);


}
