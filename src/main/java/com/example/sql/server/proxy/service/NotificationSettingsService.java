package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.NotificationSettings;

public interface NotificationSettingsService {

    NotificationSettings getByUser(Long userId);


    NotificationSettings update(Long userId, NotificationSettings newSettings);
}
