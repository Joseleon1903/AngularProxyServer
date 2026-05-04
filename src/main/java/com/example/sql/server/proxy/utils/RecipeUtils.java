package com.example.sql.server.proxy.utils;

import com.example.sql.server.proxy.domain.Recipe;
import com.example.sql.server.proxy.dto.RecipeResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class RecipeUtils {

    public static List<RecipeResponseDTO> toList(List<Recipe> entities){
        System.out.println("entering RecipeUtils:toList");
        List<RecipeResponseDTO> reponse = new ArrayList<>();
        entities.forEach( ent ->{
            reponse.add(toType(ent));
        });
        System.out.println("listSize: "+reponse.size() );
        return reponse;
    }

    public static RecipeResponseDTO toType(Recipe entity){
        System.out.println("entering RecipeUtils:toList");
        RecipeResponseDTO dto =  new RecipeResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImageUrl());
        dto.setTag(entity.getTag());
        dto.setPrepTime(entity.getPrepTime());
        dto.setYield(entity.getYield());
        dto.setDifficulty(entity.getDifficulty());
        return dto;
    }


}
