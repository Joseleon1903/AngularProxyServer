package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Sale;
import com.example.sql.server.proxy.domain.SaleItem;
import com.example.sql.server.proxy.repository.CustomerRepository;
import com.example.sql.server.proxy.repository.SaleRepository;
import com.example.sql.server.proxy.request.CreateSaleRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SaleServiceImpl implements SaleService{

    private final SaleRepository repository;

    private final CustomerRepository customerRepository;

    public SaleServiceImpl(SaleRepository repository, CustomerRepository customerRepository) {
        this.repository = repository;
        this.customerRepository = customerRepository;
    }

    // Obtener todas las ventas
    public List<Sale> findAll() {
        return repository.findAll();
    }

    // Obtener por ID
    public Optional<Sale> findById(Long id) {
        return repository.findById(id);
    }

    public Sale createSale(CreateSaleRequest saleRequest) {

        Sale sale = new Sale();

        sale.setSaleDate(saleRequest.getSaleDate());
        sale.setReferenceNumber(saleRequest.getReferenceNumber());
        sale.setCustomer(customerRepository.findById(saleRequest.getCustomerId()).get());

        sale.setDescription(saleRequest.getSaleDescripcion());
        sale.setTotalAmount(saleRequest.getTotalAmount());
        sale.setDocumentUrl(saleRequest.getDocumentUrl());

        saleRequest.getProducts().forEach( pro ->{
            System.out.println(pro);
            SaleItem item = new SaleItem();
            item.setProductId(pro.getProductId());
            item.setProductName(pro.getProductName());
            item.setQuantity(pro.getQuantity());
            item.setUnitPrice(pro.getUnitPrice());
            item.setSubtotal(pro.getSubtotal());
            sale.getSaleItemList().add(item);
        });
        sale.setPaymentMethod(saleRequest.getPaymentMethod().toString());
        sale.setCreatedAt(LocalDateTime.now());

        return repository.save(sale);
    }


    // Crear venta
    public Sale save(Sale sale) {
        sale.setCreatedAt(LocalDateTime.now());
        return repository.save(sale);
    }

    // Actualizar venta
    public Sale update(Long id, Sale sale) {
        Sale existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found"));

        existing.setSaleDate(sale.getSaleDate());
        existing.setReferenceNumber(sale.getReferenceNumber());
//        existing.setCustomerName(sale.getCustomerName());
//        existing.setProductDescription(sale.getProductDescription());
//        existing.setQuantity(sale.getQuantity());
//        existing.setUnitPrice(sale.getUnitPrice());
        existing.setPaymentMethod(sale.getPaymentMethod());

        return repository.save(existing);
    }

    // Eliminar venta
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
