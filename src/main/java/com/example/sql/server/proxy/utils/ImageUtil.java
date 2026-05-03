package com.example.sql.server.proxy.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ImageUtil {

    public static String generateImageName(String type, String extension){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");
        String timestamp = LocalDateTime.now().format(formatter);
        return "IMG_"+type.toUpperCase()+"_" + timestamp + "." + extension;
    }



}
