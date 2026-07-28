package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.domain.Inventory;
import com.example.sql.server.proxy.response.StockItemResponse;
import com.example.sql.server.proxy.response.StockResponse;
import com.example.sql.server.proxy.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<List<Inventory>> getInventory() {
        return ResponseEntity.ok(inventoryService.getInventoryList());
    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
        Inventory inventoryOut = inventoryService.create(inventory);
        return ResponseEntity.ok(inventoryOut);
    }

}
