package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.response.SalesResponseCard;
import com.example.sql.server.proxy.response.TransactionResponse;
import com.example.sql.server.proxy.service.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    private final SalesService salesService;


    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    // ============================
    // GET ALL Sales
    // ============================
    @GetMapping("/summary-cards")
    public ResponseEntity<List<SalesResponseCard>> getSummaryCards() {
        return ResponseEntity.ok(salesService.getSalesResponseCard());
    }

    // ============================
    // GET ALL Transaction
    // ============================
    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionResponse>> getSales() {
        return ResponseEntity.ok(salesService.getTransactions());
    }

}
