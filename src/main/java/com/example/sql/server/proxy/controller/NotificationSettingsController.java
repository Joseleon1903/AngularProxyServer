package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.domain.NotificationSettings;
import com.example.sql.server.proxy.service.NotificationSettingsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification-settings")
public class NotificationSettingsController {

    private final NotificationSettingsService service;

    public NotificationSettingsController(NotificationSettingsService service) {
        this.service = service;
    }

    // Obtener configuración del usuario
    @GetMapping("/user/{userId}")
    public NotificationSettings getByUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }

    // Actualizar configuración
    @PutMapping("/user/{userId}")
    public NotificationSettings update(
            @PathVariable Long userId,
            @RequestBody NotificationSettings settings) {

        return service.update(userId, settings);
    }


}