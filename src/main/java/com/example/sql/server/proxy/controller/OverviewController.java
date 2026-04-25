package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.response.SalesResponse;
import com.example.sql.server.proxy.response.SummaryResponseCard;
import com.example.sql.server.proxy.response.TopSellerProductResponse;
import com.example.sql.server.proxy.service.OverviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/overview")
public class OverviewController {


    private final OverviewService overviewService;

    public OverviewController(OverviewService overviewService) {
        this.overviewService = overviewService;
    }

    // ============================
    // GET ALL Summary
    // ============================
    @GetMapping("/summary")
    public ResponseEntity<List<SummaryResponseCard>> getSummaryCards() {
        return ResponseEntity.ok(overviewService.getSummaryCards());
    }

    // ============================
    // GET ALL Sales
    // ============================
    @GetMapping("/sales")
    public ResponseEntity<List<SalesResponse>> getSales() {
        return ResponseEntity.ok(overviewService.getSales());
    }

    // ============================
    // GET ALL Top Seller Product
    // ============================
    @GetMapping("/top-seller-product")
    public ResponseEntity<List<TopSellerProductResponse>> getTopSellerProduct() {
        return ResponseEntity.ok(overviewService.getTopSellerProduct());
    }

}
