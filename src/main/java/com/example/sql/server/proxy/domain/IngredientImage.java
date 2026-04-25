package com.example.sql.server.proxy.domain;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.UUID;

@Entity
@Table(name = "IngredientsImages")
public class IngredientImage {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Lob
    @Column(name = "Image", columnDefinition = "VARBINARY(MAX)")
    private byte[] image;

    public IngredientImage(UUID id, String name, byte[] image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public IngredientImage() {}

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "IngredientImage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
