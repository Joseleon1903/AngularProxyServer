package com.example.sql.server.proxy.response;

import java.math.BigDecimal;

public class TransactionResponse {

    private String id;
    private String customerName;
    private String date;
    private String status;
    private BigDecimal amount;

    public TransactionResponse(String id, String customerName, String date, String status, BigDecimal amount) {
        this.id = id;
        this.customerName = customerName;
        this.date = date;
        this.status = status;
        this.amount = amount;
    }

    public TransactionResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                '}';
    }
}
