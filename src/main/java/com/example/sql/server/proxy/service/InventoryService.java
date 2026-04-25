package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.response.StockItemResponse;
import com.example.sql.server.proxy.response.StockResponse;

import java.util.List;

public interface InventoryService {

    List<StockResponse> getStockInventory();

    List<StockItemResponse> getStockItems();

}
