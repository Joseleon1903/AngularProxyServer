package com.example.sql.server.proxy.utils;

import com.example.sql.server.proxy.domain.Product;
import com.example.sql.server.proxy.response.ProductResponse;

import java.util.UUID;

public class ProductUtils {


    public static ProductResponse toDTO(Product product) {

        if (product == null) return null;

        ProductResponse resp = new ProductResponse();
        resp.setId(product.getProductId().toString());

        return resp;
    }
}
