package com.example.sql.server.proxy.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Sales" , schema = "WebApp")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "saleDate", nullable = false)
    private LocalDate saleDate;

    @Column(name = "referenceNumber", length = 20, nullable = false)
    private String referenceNumber;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;

    @Column(name = "description", length = 255)
    private String description;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<SaleItem> saleItemList;

    // Campo calculado en la BD → solo lectura
    @Column(name = "totalAmount", insertable = false, updatable = false)
    private BigDecimal totalAmount;

    @Column(name = "paymentMethod", length = 50, nullable = false)
    private String paymentMethod;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "documentUrl", length = 255)
    private String documentUrl;

    // ====== Getters y Setters ======

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<SaleItem> getSaleItemList() {
        if(saleItemList == null){
            saleItemList = new ArrayList<>();
        }
        return saleItemList;
    }

    public void setSaleItemList(List<SaleItem> saleItemList) {
        this.saleItemList = saleItemList;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", saleDate=" + saleDate +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", customer=" + customer +
                ", description='" + description + '\'' +
                ", saleItemList=" + saleItemList +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", createdAt=" + createdAt +
                ", documentUrl='" + documentUrl + '\'' +
                '}';
    }
}
