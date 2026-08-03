package com.example.sql.server.proxy.response;

import java.io.Serializable;

public class StockResponse implements Serializable {

    private String title;
    private String value;
    private String subtitle;
    private String status;

    public StockResponse(String title, String value, String subtitle, String status) {
        this.title = title;
        this.value = value;
        this.subtitle = subtitle;
        this.status = status;
    }

    public StockResponse() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StockResponse{" +
                "title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
