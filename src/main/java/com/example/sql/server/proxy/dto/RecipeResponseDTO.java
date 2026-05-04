package com.example.sql.server.proxy.dto;

import java.io.Serializable;
import java.util.UUID;

public class RecipeResponseDTO implements Serializable {

    private UUID id;
    private String name;
    private String image;
    private String tag;
    private String prepTime;
    private String yield;
    private String difficulty;

    public RecipeResponseDTO(String name, String image, String tag, String prepTime, String yield, String difficulty) {
        this.name = name;
        this.image = image;
        this.tag = tag;
        this.prepTime = prepTime;
        this.yield = yield;
        this.difficulty = difficulty;
    }
    public RecipeResponseDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RecipeResponseDTO{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", tag='" + tag + '\'' +
                ", prepTime='" + prepTime + '\'' +
                ", yield='" + yield + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }



}
