package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.SaleAttachment;

public interface SaleAttachmenService {

    SaleAttachment uploadRecipeImage(SaleAttachment image);

    SaleAttachment getRecipeImageByName(String name);

}
