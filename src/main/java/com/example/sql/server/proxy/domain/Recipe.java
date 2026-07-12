package com.example.sql.server.proxy.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Recipes" , schema = "WebApp")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String imageUrl;
    private String tag;
    private String prepTime;
    private String cookingTime;
    private String yield;
    private String difficulty;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipeStep", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<PreparationStep> preparationSteps = new ArrayList<>();


    // getters & setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getYield() {
        return yield;
    }

    public void setYield(String yield) {
        this.yield = yield;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<PreparationStep> getPreparationSteps() {
        return preparationSteps;
    }

    public void setPreparationSteps(List<PreparationStep> preparationSteps) {
        this.preparationSteps = preparationSteps;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", tag='" + tag + '\'' +
                ", prepTime='" + prepTime + '\'' +
                ", cookingTime='" + cookingTime + '\'' +
                ", yield='" + yield + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", createdAt=" + createdAt +
                ", ingredients=" + ingredients +
                ", preparationSteps=" + preparationSteps +
                '}';
    }
}
