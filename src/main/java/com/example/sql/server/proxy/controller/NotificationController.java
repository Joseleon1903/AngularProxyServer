package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.domain.Notification;
import com.example.sql.server.proxy.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    // Crear
    @PostMapping
    public Notification create(@RequestBody Notification notification) {
        return service.create(notification);
    }

    // Obtener todas por usuario
    @GetMapping("/user/{userId}")
    public List<Notification> getByUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }

    // Obtener no leídas
    @GetMapping("/user/{userId}/unread")
    public List<Notification> getUnread(@PathVariable Long userId) {
        return service.getUnread(userId);
    }

    // Marcar como leída
    @PutMapping("/{id}/read")
    public Notification markAsRead(@PathVariable Long id) {
        return service.markAsRead(id);
    }

    // Marcar todas como leídas
    @PutMapping("/user/{userId}/read-all")
    public void markAllAsRead(@PathVariable Long userId) {
        service.markAllAsRead(userId);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}