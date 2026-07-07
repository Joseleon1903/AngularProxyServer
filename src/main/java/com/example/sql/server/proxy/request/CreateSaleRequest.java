package com.example.sql.server.proxy.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CreateSaleRequest  implements Serializable {

    private Long id;
    private LocalDate saleDate;
    private String referenceNumber;
    private Long customerId;
    private String saleDescripcion;
    private List<SaleItemRequest> products;
    private Double totalAmount;
    private PaymentMethod paymentMethod;
    private LocalDateTime createdAt;
    private String documentUrl;


    public CreateSaleRequest(Long id, LocalDate saleDate, String referenceNumber, Long customerId, String saleDescripcion,
                             List<SaleItemRequest> products, Double totalAmount, PaymentMethod paymentMethod,
                             LocalDateTime createdAt, String documentUrl) {
        this.id = id;
        this.saleDate = saleDate;
        this.referenceNumber = referenceNumber;
        this.customerId = customerId;
        this.saleDescripcion = saleDescripcion;
        this.products = products;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.createdAt = createdAt;
        this.documentUrl = documentUrl;
    }

    public CreateSaleRequest() {
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getSaleDescripcion() {
        return saleDescripcion;
    }

    public void setSaleDescripcion(String saleDescripcion) {
        this.saleDescripcion = saleDescripcion;
    }

    public List<SaleItemRequest> getProducts() {
        return products;
    }

    public void setProducts(List<SaleItemRequest> products) {
        this.products = products;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    @Override
    public String toString() {
        return "CreateSaleRequest{" +
                "id=" + id +
                ", saleDate=" + saleDate +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", customerId=" + customerId +
                ", saleDescripcion='" + saleDescripcion + '\'' +
                ", products=" + products +
                ", totalAmount=" + totalAmount +
                ", paymentMethod=" + paymentMethod +
                ", createdAt=" + createdAt +
                ", documentUrl='" + documentUrl + '\'' +
                '}';
    }
}
