package com.example.sql.server.proxy.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "PreparationSteps")
public class PreparationStep {

    @Id
    @GeneratedValue
    private UUID id;

    private String description;
    private Boolean active;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime lastChangeAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    @JsonBackReference
    private Recipe recipeStep;

    public PreparationStep(UUID id, String description, Boolean active, LocalDateTime createdAt, LocalDateTime lastchangeAt, Recipe recipe) {
        this.id = id;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.lastChangeAt = lastchangeAt;
        this.recipeStep = recipe;
    }

    public PreparationStep() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastChangeAt() {
        return lastChangeAt;
    }

    public void setLastChangeAt(LocalDateTime lastChangeAt) {
        this.lastChangeAt = lastChangeAt;
    }


    public Recipe getRecipeStep() {
        return recipeStep;
    }

    public void setRecipeStep(Recipe recipeStep) {
        this.recipeStep = recipeStep;
    }



    @Override
    public String toString() {
        return "PreparationStep{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", createdAt=" + createdAt +
                ", lastchangeAt=" + lastChangeAt +
                ", recipe=" + recipeStep +
                '}';
    }
}
