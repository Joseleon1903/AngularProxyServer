package com.example.sql.server.proxy.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionResponse implements Serializable {

    private Long id;
    private LocalDate saleDate;
    private String referenceNumber;
    private String customerName;
    private String customerType;
    private String description;
    private Integer productCount;
    private BigDecimal totalAmount;
    private String paymentMethod;


    public TransactionResponse(Long id, LocalDate saleDate, String referenceNumber, String customerName, String customerType, String description, Integer productCount, BigDecimal totalAmount, String paymentMethod) {
        this.id = id;
        this.saleDate = saleDate;
        this.referenceNumber = referenceNumber;
        this.customerName = customerName;
        this.customerType = customerType;
        this.description = description;
        this.productCount = productCount;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }

    public TransactionResponse(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "id=" + id +
                ", saleDate=" + saleDate +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerType='" + customerType + '\'' +
                ", description='" + description + '\'' +
                ", productCount=" + productCount +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
