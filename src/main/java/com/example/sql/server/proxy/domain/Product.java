package com.example.sql.server.proxy.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Products", schema = "WebApp")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long productId;

    @Column(name = "TenantId", nullable = false)
    private UUID tenantId;

    @ManyToOne
    @JoinColumn(name = "CategoryId", nullable = false)
    private Category categoryId;

    @ManyToOne
    @JoinColumn(name = "ProductTypeId", nullable = false)
    private ProductType productTypeId;

    @ManyToOne
    @JoinColumn(name = "UnitId")
    private Unit unitId;

    @Column(name = "Name", nullable = false, length = 120)
    private String name;

    @Column(name = "Description", length = 120)
    private String description;

    @Column(name = "PriceAmount", nullable = false, precision = 18, scale = 2)
    private BigDecimal priceAmount;

    @Column(name = "PriceCurrency", nullable = false, length = 3)
    private String priceCurrency;

    @Column(name = "ProductionCostAmount", nullable = false, precision = 18, scale = 2)
    private BigDecimal productionCostAmount;

    @Column(name = "ProductionCostCurrency", nullable = false, length = 3)
    private String productionCostCurrency;

    @Column(name = "ImageUrl", length = 500)
    private String imageUrl;

    @Column(name = "ImageId")
    private UUID imageId;

    @Column(name = "IsActive", nullable = false)
    private Boolean isActive;

    @Column(name = "IsDeleted", nullable = false)
    private Boolean isDeleted;

    @Column(name = "CreatedAtUtc", nullable = false)
    private LocalDateTime createdAtUtc;

    @Column(name = "UpdatedAtUtc", nullable = false)
    private LocalDateTime updatedAtUtc;

    @Column(name = "DeletedAtUtc")
    private LocalDateTime deletedAtUtc;

    // ===== Constructores =====
    public Product() {}

    // ===== Getters y Setters =====
    // (puedes generar con IDE o usar Lombok)


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public UUID getTenantId() {
        return tenantId;
    }

    public void setTenantId(UUID tenantId) {
        this.tenantId = tenantId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public ProductType getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(ProductType productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
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

    public BigDecimal getPriceAmount() {
        return priceAmount;
    }

    public void setPriceAmount(BigDecimal priceAmount) {
        this.priceAmount = priceAmount;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public BigDecimal getProductionCostAmount() {
        return productionCostAmount;
    }

    public void setProductionCostAmount(BigDecimal productionCostAmount) {
        this.productionCostAmount = productionCostAmount;
    }

    public String getProductionCostCurrency() {
        return productionCostCurrency;
    }

    public void setProductionCostCurrency(String productionCostCurrency) {
        this.productionCostCurrency = productionCostCurrency;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public UUID getImageId() {
        return imageId;
    }

    public void setImageId(UUID imageId) {
        this.imageId = imageId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", tenantId=" + tenantId +
                ", categoryId=" + categoryId +
                ", productTypeId=" + productTypeId +
                ", unitId=" + unitId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priceAmount=" + priceAmount +
                ", priceCurrency='" + priceCurrency + '\'' +
                ", productionCostAmount=" + productionCostAmount +
                ", productionCostCurrency='" + productionCostCurrency + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageId=" + imageId +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                ", createdAtUtc=" + createdAtUtc +
                ", updatedAtUtc=" + updatedAtUtc +
                ", deletedAtUtc=" + deletedAtUtc +
                '}';
    }
}