package com.example.sql.server.proxy.response;

import java.math.BigDecimal;

public class SummaryResponseCard {

    private String title;
    private Integer value;

    private BigDecimal porcentageCahnge;

    private String iconUrl;

    private boolean isPositive;

    public SummaryResponseCard(String title, Integer value, BigDecimal porcentageCahnge, String iconUrl, boolean isPositive) {
        this.title = title;
        this.value = value;
        this.porcentageCahnge = porcentageCahnge;
        this.iconUrl = iconUrl;
        this.isPositive = isPositive;
    }

    public SummaryResponseCard() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BigDecimal getPorcentageCahnge() {
        return porcentageCahnge;
    }

    public void setPorcentageCahnge(BigDecimal porcentageCahnge) {
        this.porcentageCahnge = porcentageCahnge;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }

    @Override
    public String toString() {
        return "SummaryResponseCard{" +
                "title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", porcentageCahnge=" + porcentageCahnge +
                ", iconUrl='" + iconUrl + '\'' +
                ", isPositive=" + isPositive +
                '}';
    }
}
