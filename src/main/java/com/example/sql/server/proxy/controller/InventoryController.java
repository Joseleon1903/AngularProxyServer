package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.response.StockItemResponse;
import com.example.sql.server.proxy.response.StockResponse;
import com.example.sql.server.proxy.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // ============================
    // GET ALL stocks
    // ============================
    @GetMapping("/stocks")
    public ResponseEntity<List<StockResponse>> getStockInventory() {
        return ResponseEntity.ok(inventoryService.getStockInventory());
    }

    // ============================
    // GET ALL stock items
    // ============================
    @GetMapping("/stock-items")
    public ResponseEntity<List<StockItemResponse>> getStockItems() {
        return ResponseEntity.ok(inventoryService.getStockItems());
    }

}
