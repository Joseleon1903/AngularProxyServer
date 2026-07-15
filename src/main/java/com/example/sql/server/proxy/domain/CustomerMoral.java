package com.example.sql.server.proxy.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "CustomerMoral", schema = "WebApp")
@PrimaryKeyJoinColumn(name = "CustomerId")
public class CustomerMoral extends Customer{

    @Column(name = "BusinessName", nullable = false, length = 150)
    private String businessName;

    @Column(name = "RNC", nullable = false, length = 20)
    private String rnc;

    public CustomerMoral() {
    }

    @PrePersist
    public void setType() {
        super.setCustomerType(CustomerType.M);
    }

    public CustomerMoral(Long id, CustomerType customerType, String phone, String email, LocalDateTime createdAt, Boolean isActive, String businessName, String rnc) {
        super(id, customerType, phone, email, createdAt, isActive);
        this.businessName = businessName;
        this.rnc = rnc;
    }

    public CustomerMoral(String businessName, String rnc) {
        this.businessName = businessName;
        this.rnc = rnc;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getRnc() {
        return rnc;
    }

    public void setRnc(String rnc) {
        this.rnc = rnc;
    }

    @Override
    public String toString() {
        return "CustomerMoral{" +
                "businessName='" + businessName + '\'' +
                ", rnc='" + rnc + '\'' +
                '}';
    }
}
