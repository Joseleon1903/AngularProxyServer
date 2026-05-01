package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.SaleAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SaleAttachmentRepository extends JpaRepository<SaleAttachment, UUID> {

    SaleAttachment getByName(String name);
}
