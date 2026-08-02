package com.example.sql.server.proxy.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SystemExecuteLog", schema = "WebApp")
public class SystemExecuteLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long systemExecuteLogId;

    private String processName;

    private String processCode;

    private UUID executionId;

    private String status;

    private String value;

    private LocalDateTime executeDateStart;

    private LocalDateTime executeDateEnd;

    private String executedBy;

    private String hostName;

    private String applicationName;

    public SystemExecuteLog(Long systemExecuteLogId, String processName, String processCode, UUID executionId, String status, LocalDateTime executeDateStart, LocalDateTime executeDateEnd, String executedBy, String hostName, String applicationName) {
        this.systemExecuteLogId = systemExecuteLogId;
        this.processName = processName;
        this.processCode = processCode;
        this.executionId = executionId;
        this.status = status;
        this.executeDateStart = executeDateStart;
        this.executeDateEnd = executeDateEnd;
        this.executedBy = executedBy;
        this.hostName = hostName;
        this.applicationName = applicationName;
    }

    public SystemExecuteLog() {
    }

    public Long getSystemExecuteLogId() {
        return systemExecuteLogId;
    }

    public void setSystemExecuteLogId(Long systemExecuteLogId) {
        this.systemExecuteLogId = systemExecuteLogId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public UUID getExecutionId() {
        return executionId;
    }

    public void setExecutionId(UUID executionId) {
        this.executionId = executionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getExecuteDateStart() {
        return executeDateStart;
    }

    public void setExecuteDateStart(LocalDateTime executeDateStart) {
        this.executeDateStart = executeDateStart;
    }

    public LocalDateTime getExecuteDateEnd() {
        return executeDateEnd;
    }

    public void setExecuteDateEnd(LocalDateTime executeDateEnd) {
        this.executeDateEnd = executeDateEnd;
    }

    public String getExecutedBy() {
        return executedBy;
    }

    public void setExecutedBy(String executedBy) {
        this.executedBy = executedBy;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SystemExecuteLog{" +
                "systemExecuteLogId=" + systemExecuteLogId +
                ", processName='" + processName + '\'' +
                ", processCode='" + processCode + '\'' +
                ", executionId=" + executionId +
                ", status='" + status + '\'' +
                ", value='" + value + '\'' +
                ", executeDateStart=" + executeDateStart +
                ", executeDateEnd=" + executeDateEnd +
                ", executedBy='" + executedBy + '\'' +
                ", hostName='" + hostName + '\'' +
                ", applicationName='" + applicationName + '\'' +
                '}';
    }
}
