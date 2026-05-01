package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.SaleAttachment;
import com.example.sql.server.proxy.repository.SaleAttachmentRepository;
import org.springframework.stereotype.Service;

@Service
public class SaleAttachmenServiceImpl implements SaleAttachmenService{

    private final SaleAttachmentRepository saleAttachmentRepository;

    public SaleAttachmenServiceImpl(SaleAttachmentRepository saleAttachmentRepository) {
        this.saleAttachmentRepository = saleAttachmentRepository;
    }


    @Override
    public SaleAttachment uploadRecipeImage(SaleAttachment image) {
        return saleAttachmentRepository.save(image);
    }

    @Override
    public SaleAttachment getRecipeImageByName(String name) {
        return saleAttachmentRepository.getByName(name);
    }
}
