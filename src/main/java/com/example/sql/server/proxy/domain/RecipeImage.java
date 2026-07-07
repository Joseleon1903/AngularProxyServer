package com.example.sql.server.proxy.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

@Entity
@Table(name = "RecipesImages" , schema = "WebApp")
public class RecipeImage implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Lob
    @Column(name = "Image", columnDefinition = "VARBINARY(MAX)")
    private byte[] image;

    public RecipeImage(Long id, String name, byte[] image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public RecipeImage() {}

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "RecipeImage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
