package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Notification;

import java.util.List;

public interface NotificationService {

    Notification create(Notification notification);

    List<Notification> getByUser(Long userId);

    List<Notification> getUnread(Long userId);

    Notification markAsRead(Long id);

    void markAllAsRead(Long userId);

    void delete(Long id);
}
