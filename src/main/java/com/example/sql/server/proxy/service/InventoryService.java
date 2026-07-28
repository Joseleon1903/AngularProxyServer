package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Inventory;
import com.example.sql.server.proxy.response.StockItemResponse;
import com.example.sql.server.proxy.response.StockResponse;

import java.util.List;

public interface InventoryService {

    Inventory create(Inventory entity);

    Inventory update(Long id, Inventory entity);

    Inventory getById(Long id);

    List<Inventory> getInventoryList();

    List<StockResponse> getStockInventory();

    List<StockItemResponse> getStockItems();

}
