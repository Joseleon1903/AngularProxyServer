package com.example.sql.server.proxy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @GetMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.ok().body("version: 0.0.1");
    }


}
