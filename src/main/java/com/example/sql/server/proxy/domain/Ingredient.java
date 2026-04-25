package com.example.sql.server.proxy.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Ingredients")
public class Ingredient {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String urlImage;
    private String quantity;      // "0.5"
    private String units;         // "Kg"
    private Double unitPrice;     // 500.00
    private String priceCurrency; // USD
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    @JsonBackReference
    private Recipe recipe;

    // getters & setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", quantity='" + quantity + '\'' +
                ", units='" + units + '\'' +
                ", unitPrice=" + unitPrice +
                ", priceCurrency='" + priceCurrency + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
