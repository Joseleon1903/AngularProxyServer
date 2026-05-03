package com.example.sql.server.proxy.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductResponse {

    private String id;
    private String tenantId;
    private String name;
    private String description;
    private Boolean active;
    private Boolean deleted;
    private String categoryId;
    private String productTypeId;
    private String unitId;
    private Integer unitType;
    private BigDecimal priceAmount;
    private String priceCurrency;
    private BigDecimal productionCostAmount;
    private String productionCostCurrency;
    private String imageId;
    private String imageUrl;
    private LocalDateTime createdAtUtc;
    private LocalDateTime updatedAtUtc;
    private LocalDateTime deletedAtUtc;

    public ProductResponse(String id, String tenantId, String name, String description, Boolean active, Boolean deleted, String categoryId, String productTypeId, String unitId, Integer unitType, BigDecimal priceAmount, String priceCurrency, BigDecimal productionCostAmount, String productionCostCurrency, String imageId, String imageUrl, LocalDateTime createdAtUtc, LocalDateTime updatedAtUtc, LocalDateTime deletedAtUtc) {
        this.id = id;
        this.tenantId = tenantId;
        this.name = name;
        this.description = description;
        this.active = active;
        this.deleted = deleted;
        this.categoryId = categoryId;
        this.productTypeId = productTypeId;
        this.unitId = unitId;
        this.unitType = unitType;
        this.priceAmount = priceAmount;
        this.priceCurrency = priceCurrency;
        this.productionCostAmount = productionCostAmount;
        this.productionCostCurrency = productionCostCurrency;
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        this.createdAtUtc = createdAtUtc;
        this.updatedAtUtc = updatedAtUtc;
        this.deletedAtUtc = deletedAtUtc;
    }

    public ProductResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public Integer getUnitType() {
        return unitType;
    }

    public void setUnitType(Integer unitType) {
        this.unitType = unitType;
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

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
        return "ProductResponse{" +
                "id='" + id + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", deleted=" + deleted +
                ", categoryId='" + categoryId + '\'' +
                ", productTypeId='" + productTypeId + '\'' +
                ", unitId='" + unitId + '\'' +
                ", unitType=" + unitType +
                ", priceAmount=" + priceAmount +
                ", priceCurrency='" + priceCurrency + '\'' +
                ", productionCostAmount=" + productionCostAmount +
                ", productionCostCurrency='" + productionCostCurrency + '\'' +
                ", imageId='" + imageId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", createdAtUtc=" + createdAtUtc +
                ", updatedAtUtc=" + updatedAtUtc +
                ", deletedAtUtc=" + deletedAtUtc +
                '}';
    }
}
