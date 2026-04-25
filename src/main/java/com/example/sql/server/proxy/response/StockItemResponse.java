package com.example.sql.server.proxy.response;

public class StockItemResponse {

    private String name;
    private String category;
    private Integer stock;
    private String status;

    public StockItemResponse(String name, String category, Integer stock, String status) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.status = status;
    }

    public StockItemResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StockItemResponse{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", stock=" + stock +
                ", status='" + status + '\'' +
                '}';
    }
}
