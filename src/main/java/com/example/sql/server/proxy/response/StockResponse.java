package com.example.sql.server.proxy.response;

public class StockResponse {

    private String tittle;
    private Integer totalItems;
    private String itemUrl;

    public StockResponse(String tittle, Integer totalItems, String itemUrl) {
        this.tittle = tittle;
        this.totalItems = totalItems;
        this.itemUrl = itemUrl;
    }

    public StockResponse() {
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    @Override
    public String toString() {
        return "StockItemResponse{" +
                "tittle='" + tittle + '\'' +
                ", totalItems=" + totalItems +
                ", itemUrl='" + itemUrl + '\'' +
                '}';
    }
}
