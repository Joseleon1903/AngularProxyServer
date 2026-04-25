package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.ProductImage;

public interface ProductImageService {

    ProductImage uploadImage(ProductImage image);

    ProductImage getImageByName(String name);


}
