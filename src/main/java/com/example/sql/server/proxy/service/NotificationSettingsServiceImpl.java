package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.NotificationSettings;
import com.example.sql.server.proxy.repository.NotificationSettingsRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationSettingsServiceImpl implements NotificationSettingsService{

    private final NotificationSettingsRepository repository;

    public NotificationSettingsServiceImpl(NotificationSettingsRepository repository) {
        this.repository = repository;
    }

    // Obtener configuración (o crear por defecto)
    public NotificationSettings getByUser(Long userId) {
        return repository.findByUserId(userId)
                .orElseGet(() -> createDefault(userId));
    }

    // Crear configuración por defecto
    private NotificationSettings createDefault(Long userId) {
        NotificationSettings settings = new NotificationSettings();
        settings.setUserId(userId);
        return repository.save(settings);
    }

    // Actualizar configuración
    public NotificationSettings update(Long userId, NotificationSettings newSettings) {
        NotificationSettings settings = repository.findByUserId(userId)
                .orElseGet(() -> createDefault(userId));

        settings.setEmailEnabled(newSettings.getEmailEnabled());
        settings.setPushEnabled(newSettings.getPushEnabled());
        settings.setSmsEnabled(newSettings.getSmsEnabled());

        return repository.save(settings);
    }

}
