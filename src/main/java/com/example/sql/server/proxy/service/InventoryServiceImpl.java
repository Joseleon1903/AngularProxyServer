package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Inventory;
import com.example.sql.server.proxy.domain.Product;
import com.example.sql.server.proxy.repository.InventoryRepository;
import com.example.sql.server.proxy.repository.ProductRepository;
import com.example.sql.server.proxy.repository.ProductTypeRepository;
import com.example.sql.server.proxy.response.StockItemResponse;
import com.example.sql.server.proxy.response.StockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{

    private final InventoryRepository inventoryRepository;

    private final ProductRepository productRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository, ProductRepository productRepository){
        this.inventoryRepository = inventoryRepository;
        this.productRepository=productRepository;
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

        List<Product> productos = productRepository.findAll();

        Long productosActivos = productos.stream().filter(Product::getActive).count();
        Long productosIncativos = productos.stream().filter(Product -> !Product.getActive()).count();
        int totalProductos = productos.size();

        StockResponse s1 = new StockResponse();
        s1.setTitle("Cantidad de productos totales");
        s1.setValue(String.valueOf(totalProductos));
        s1.setSubtitle("Total de productos registrados en el sistema.");
        s1.setStatus("NEUTRAL");

        StockResponse s2 = new StockResponse();
        s2.setTitle("Cantidad de productos activos");
        s2.setValue(String.valueOf(productosActivos));
        s2.setSubtitle("Total de productos activos registrados en el sistema.");
        s2.setStatus("POSITIVE");

        StockResponse s3 = new StockResponse();
        s3.setTitle("Cantidad de productos incactivos");
        s3.setValue(String.valueOf(productosIncativos));
        s3.setSubtitle("Total de productos inactivos registrados en el sistema.");
        s3.setStatus("NEGATIVE");

        list.add(s1);
        list.add(s2);
        list.add(s3);

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
