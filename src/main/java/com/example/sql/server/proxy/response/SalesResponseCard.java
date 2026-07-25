package com.example.sql.server.proxy.response;

import java.math.BigDecimal;

public class SalesResponseCard {

    private String title;
    private BigDecimal value;
    private BigDecimal changePorcentage;
    private String subtitle="vs last 30 days";

    public SalesResponseCard(String title, BigDecimal value, BigDecimal changePorcentage, String subtitle) {
        this.title = title;
        this.value = value;
        this.changePorcentage = changePorcentage;
        this.subtitle = subtitle;
    }

    public SalesResponseCard() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getChangePorcentage() {
        return changePorcentage;
    }

    public void setChangePorcentage(BigDecimal changePorcentage) {
        this.changePorcentage = changePorcentage;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @Override
    public String toString() {
        return "SalesResponseCard{" +
                "title='" + title + '\'' +
                ", value=" + value +
                ", changePorcentage=" + changePorcentage +
                ", subtitle='" + subtitle + '\'' +
                '}';
    }
}
