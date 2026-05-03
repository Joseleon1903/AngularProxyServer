package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Notification;
import com.example.sql.server.proxy.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService{

    private final NotificationRepository repository;

    public NotificationServiceImpl(NotificationRepository repository) {
        this.repository = repository;
    }

    // Crear notificación
    public Notification create(Notification notification) {
        return repository.save(notification);
    }

    // Obtener todas por usuario
    public List<Notification> getByUser(Long userId) {
        return repository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    // Obtener no leídas
    public List<Notification> getUnread(Long userId) {
        return repository.findByUserIdAndIsReadFalseOrderByCreatedAtDesc(userId);
    }

    // Marcar como leída
    public Notification markAsRead(Long id) {
        Notification notif = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notif.setRead(true);
        notif.setReadAt(LocalDateTime.now());

        return repository.save(notif);
    }

    // Marcar todas como leídas
    public void markAllAsRead(Long userId) {
        List<Notification> list = repository.findByUserIdAndIsReadFalseOrderByCreatedAtDesc(userId);

        list.forEach(n -> {
            n.setRead(true);
            n.setReadAt(LocalDateTime.now());
        });

        repository.saveAll(list);
    }

    // Eliminar
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
