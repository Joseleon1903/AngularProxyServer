package com.example.sql.server.proxy.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Inventory", schema = "WebApp")
public class Inventory {

    @Id
    @GeneratedValue
    private Long id;

    private String code;

    private UUID tenantId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer currentStock;

    private Integer minStock;

    private Integer maxStock;

    private BigDecimal unitCost;

    private LocalDateTime createdAt;

    private LocalDateTime lastUpdateAt;

    private Boolean isActive;

    public Inventory(Long id, String code, UUID tenantId, Product product, Integer currentStock, Integer minStock, Integer maxStock, BigDecimal unitCost, LocalDateTime createdAt, LocalDateTime lastUpdateAt, Boolean isActive) {
        this.id = id;
        this.code = code;
        this.tenantId = tenantId;
        this.product = product;
        this.currentStock = currentStock;
        this.minStock = minStock;
        this.maxStock = maxStock;
        this.unitCost = unitCost;
        this.createdAt = createdAt;
        this.lastUpdateAt = lastUpdateAt;
        this.isActive = isActive;
    }

    public Inventory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public Integer getMinStock() {
        return minStock;
    }

    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getLastUpdateAt() {
        return lastUpdateAt;
    }

    public void setLastUpdateAt(LocalDateTime lastUpdateAt) {
        this.lastUpdateAt = lastUpdateAt;
    }

    public UUID getTenantId() {
        return tenantId;
    }

    public void setTenantId(UUID tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", tenantId=" + tenantId +
                ", product=" + product +
                ", currentStock=" + currentStock +
                ", minStock=" + minStock +
                ", maxStock=" + maxStock +
                ", unitCost=" + unitCost +
                ", createdAt=" + createdAt +
                ", lastUpdateAt=" + lastUpdateAt +
                ", isActive=" + isActive +
                '}';
    }
}
