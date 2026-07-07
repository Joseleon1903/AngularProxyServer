package com.example.sql.server.proxy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Categories", schema = "WebApp")
public class Category {

    @Id
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "TenantId", nullable = false)
    private UUID tenantId;

    @Column(name = "Name", nullable = false, columnDefinition = "nvarchar(max)")
    private String name;

    @Column(name = "Description", columnDefinition = "nvarchar(max)")
    private String description;

    @Column(name = "IsActive", nullable = false)
    private Boolean isActive;

    @Column(name = "IsDeleted", nullable = false)
    private Boolean isDeleted;

    @Column(name = "CreatedAtUtc", nullable = false)
    private LocalDateTime createdAtUtc;

    @Column(name = "UpdatedAtUtc", nullable = false)
    private LocalDateTime updatedAtUtc;

    @Column(name = "DeletedAtUtc", nullable = false)
    private LocalDateTime deletedAtUtc;

    // ============================
    // CONSTRUCTORES
    // ============================

    public Category() {
    }

    public Category(Long id, UUID tenantId, String name, String description,
                    Boolean isActive, Boolean isDeleted,
                    LocalDateTime createdAtUtc, LocalDateTime updatedAtUtc,
                    LocalDateTime deletedAtUtc) {
        this.id = id;
        this.tenantId = tenantId;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.createdAtUtc = createdAtUtc;
        this.updatedAtUtc = updatedAtUtc;
        this.deletedAtUtc = deletedAtUtc;
    }

    // ============================
    // GETTERS Y SETTERS
    // ============================


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getTenantId() {
        return tenantId;
    }

    public void setTenantId(UUID tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getCreatedAtUtc() {
        return createdAtUtc;
    }

    public void setCreatedAtUtc(LocalDateTime createdAtUtc) {
        this.createdAtUtc = createdAtUtc;
    }

    public LocalDateTime getUpdatedAtUtc() {
        return updatedAtUtc;
    }

    public void setUpdatedAtUtc(LocalDateTime updatedAtUtc) {
        this.updatedAtUtc = updatedAtUtc;
    }

    public LocalDateTime getDeletedAtUtc() {
        return deletedAtUtc;
    }

    public void setDeletedAtUtc(LocalDateTime deletedAtUtc) {
        this.deletedAtUtc = deletedAtUtc;
    }


}
