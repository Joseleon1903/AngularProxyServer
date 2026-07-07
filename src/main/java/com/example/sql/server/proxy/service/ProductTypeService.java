package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.ProductType;

import java.util.List;
import java.util.UUID;

public interface ProductTypeService {


    List<ProductType> findAll();

    ProductType findById(Long id);

    ProductType create(ProductType productType);

    ProductType update(Long id, ProductType productType);

    void delete(Long id);


}
