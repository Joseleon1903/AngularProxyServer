package com.example.sql.server.proxy.request;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductRequest {

    private String productId;
    private String name;
    private String description;

    private boolean active;

    private String categoryId;
    private String productTypeId;
    private String unitId;

    private Integer unitType;

    private BigDecimal priceAmount;
    private String priceCurrency;

    private BigDecimal productionCostAmount;
    private String productionCostCurrency;

    private UUID imageId;
    private String imageUrl;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public UUID getImageId() {
        return imageId;
    }

    public void setImageId(UUID imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductCreationRequest{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", categoryId='" + categoryId + '\'' +
                ", productTypeId='" + productTypeId + '\'' +
                ", unitId='" + unitId + '\'' +
                ", unitType=" + unitType +
                ", priceAmount=" + priceAmount +
                ", priceCurrency='" + priceCurrency + '\'' +
                ", productionCostAmount=" + productionCostAmount +
                ", productionCostCurrency='" + productionCostCurrency + '\'' +
                ", imageId=" + imageId +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
