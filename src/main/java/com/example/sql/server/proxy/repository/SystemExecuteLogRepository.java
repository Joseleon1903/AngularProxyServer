package com.example.sql.server.proxy.repository;

import com.example.sql.server.proxy.domain.SystemExecuteLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemExecuteLogRepository extends JpaRepository<SystemExecuteLog, Long> {
}
