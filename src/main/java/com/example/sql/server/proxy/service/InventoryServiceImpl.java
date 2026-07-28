package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Inventory;
import com.example.sql.server.proxy.repository.InventoryRepository;
import com.example.sql.server.proxy.response.StockItemResponse;
import com.example.sql.server.proxy.response.StockResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory create(Inventory entity) {
        return inventoryRepository.save(entity);
    }

    @Override
    public Inventory update(Long id, Inventory entity) {
        return null;
    }

    @Override
    public Inventory getById(Long id) {
        return inventoryRepository.getReferenceById(id);
    }


    @Override
    public List<Inventory> getInventoryList() {
        return inventoryRepository.findAll();
    }

    @Override
    public List<StockResponse> getStockInventory() {
        List<StockResponse> list = new ArrayList<>();

        StockResponse s1 = new StockResponse();
        s1.setTittle("Productos en Stock");
        s1.setTotalItems(150);
        s1.setItemUrl("https://i.pinimg.com/736x/bb/e3/95/bbe395c27077a804959b2c1f58f75889.jpg");

        StockResponse s2 = new StockResponse();
        s2.setTittle("Bajo Stock");
        s2.setTotalItems(35);
        s2.setItemUrl("https://i.pinimg.com/736x/bb/e3/95/bbe395c27077a804959b2c1f58f75889.jpg");

        StockResponse s3 = new StockResponse();
        s3.setTittle("Agotados");
        s3.setTotalItems(12);
        s3.setItemUrl("https://i.pinimg.com/736x/bb/e3/95/bbe395c27077a804959b2c1f58f75889.jpg");

        StockResponse s4 = new StockResponse();
        s4.setTittle("Categorías");
        s4.setTotalItems(8);
        s4.setItemUrl("https://i.pinimg.com/736x/bb/e3/95/bbe395c27077a804959b2c1f58f75889.jpg");

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        return list;
    }

    @Override
    public List<StockItemResponse> getStockItems() {
        List<StockItemResponse> list = new ArrayList<>();

        list.add(new StockItemResponse("Pan Integral", "Panadería", 50, "Disponible"));
        list.add(new StockItemResponse("Croissant", "Panadería", 20, "Bajo Stock"));
        list.add(new StockItemResponse("Pastel de Chocolate", "Repostería", 5, "Crítico"));
        list.add(new StockItemResponse("Café", "Bebidas", 100, "Disponible"));

        return list;
    }
}
