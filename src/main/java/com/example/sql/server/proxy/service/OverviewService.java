package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.response.SalesResponse;
import com.example.sql.server.proxy.response.SummaryResponseCard;
import com.example.sql.server.proxy.response.TopSellerProductResponse;

import java.util.List;

public interface OverviewService {

    List<SummaryResponseCard> getSummaryCards();

    List<SalesResponse> getSales();

    List<TopSellerProductResponse> getTopSellerProduct();
}
