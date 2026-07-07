package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.SaleAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleAttachmentRepository extends JpaRepository<SaleAttachment, Long> {

    SaleAttachment getByName(String name);
}
