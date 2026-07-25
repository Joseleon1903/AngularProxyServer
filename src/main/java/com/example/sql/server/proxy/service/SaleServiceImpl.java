package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.Customer;
import com.example.sql.server.proxy.domain.Sale;
import com.example.sql.server.proxy.domain.SaleItem;
import com.example.sql.server.proxy.repository.CustomerRepository;
import com.example.sql.server.proxy.repository.SaleRepository;
import com.example.sql.server.proxy.request.CreateSaleRequest;
import com.example.sql.server.proxy.response.SalesResponseCard;
import com.example.sql.server.proxy.response.TransactionResponse;
import com.example.sql.server.proxy.utils.CommonsUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

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


    @Override
    public List<SalesResponseCard> getSalesResponseCard() {
        List<SalesResponseCard> list = new ArrayList<>();

        List<Customer> customersList = customerRepository.findAll();

        List<Sale> sales =  repository.findAll();
        BigDecimal totalVentas = sales.stream()
                .map(Sale::getTotalAmount)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalPoprcentage = CommonsUtils.calculateSalesIncreasePercentage(sales);

        //Total de ventas
        SalesResponseCard c1 = new SalesResponseCard();
        c1.setTitle("Total de ventas");
        c1.setValue(totalVentas);
        c1.setChangePorcentage(totalPoprcentage);
        c1.setSubtitle("Ultimos 30 días");

        //Cantidad total de ventas
        SalesResponseCard c3 = new SalesResponseCard();
        c3.setTitle("Cantidad total de ventas");
        c3.setValue(new BigDecimal(sales.size()));
        c3.setChangePorcentage(new BigDecimal("100.0"));
        c3.setSubtitle("Ultimos 30 días");

        // Cantidad total de clientes
        SalesResponseCard c4 = new SalesResponseCard();
        c4.setTitle("Cantidad total de clientes");
        c4.setValue(new BigDecimal(customersList.size()));
        c4.setChangePorcentage(new BigDecimal("100.0"));
        c4.setSubtitle("Ultimos 30 días");

        list.add(c1);
        list.add(c3);
        list.add(c4);

        return list;
    }

    @Override
    public List<TransactionResponse> getTransactions() {
        List<TransactionResponse> list = new ArrayList<>();

        TransactionResponse t1 = new TransactionResponse();
        t1.setId("TXN-001");
        t1.setCustomerName("Juan Pérez");
        t1.setDate("15/04/2026");
        t1.setStatus("Completado");
        t1.setAmount(new BigDecimal("2500.00"));

        TransactionResponse t2 = new TransactionResponse();
        t2.setId("TXN-002");
        t2.setCustomerName("María Gómez");
        t2.setDate("16/04/2026");
        t2.setStatus("Pendiente");
        t2.setAmount(new BigDecimal("1200.50"));

        TransactionResponse t3 = new TransactionResponse();
        t3.setId("TXN-003");
        t3.setCustomerName("Carlos López");
        t3.setDate("17/04/2026");
        t3.setStatus("Cancelado");
        t3.setAmount(new BigDecimal("800.00"));

        TransactionResponse t4 = new TransactionResponse();
        t4.setId("TXN-004");
        t4.setCustomerName("Ana Martínez");
        t4.setDate("18/04/2026");
        t4.setStatus("Completado");
        t4.setAmount(new BigDecimal("950.75"));

        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);

        return list;
    }

}
