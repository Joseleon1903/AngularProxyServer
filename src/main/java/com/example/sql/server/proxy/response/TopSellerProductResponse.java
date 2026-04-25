package com.example.sql.server.proxy.response;

import java.math.BigDecimal;

public class TopSellerProductResponse {

    private String name;
    private String categoryName;
    private BigDecimal amount;
    private String imageUrl;

    public TopSellerProductResponse(String name, String categoryName, BigDecimal amount, String imageUrl) {
        this.name = name;
        this.categoryName = categoryName;
        this.amount = amount;
        this.imageUrl = imageUrl;
    }

    public TopSellerProductResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "TopSellerProductResponse{" +
                "name='" + name + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", amount=" + amount +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
