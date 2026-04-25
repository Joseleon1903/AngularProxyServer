package com.example.sql.server.proxy.response;

import java.math.BigDecimal;

public class SalesResponse {

    private String customerName;
    private String status;
    private String date;
    private BigDecimal amount;

    public SalesResponse(String customerName, String status, String date, BigDecimal amount) {
        this.customerName = customerName;
        this.status = status;
        this.date = date;
        this.amount = amount;
    }

    public SalesResponse() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SalesResponse{" +
                "customerName='" + customerName + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
