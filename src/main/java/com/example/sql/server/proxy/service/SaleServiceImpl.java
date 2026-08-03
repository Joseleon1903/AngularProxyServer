package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.domain.*;
import com.example.sql.server.proxy.process.ProcesarVentaService;
import com.example.sql.server.proxy.repository.CustomerRepository;
import com.example.sql.server.proxy.repository.SaleRepository;
import com.example.sql.server.proxy.request.CreateSaleRequest;
import com.example.sql.server.proxy.response.SalesResponseCard;
import com.example.sql.server.proxy.response.TransactionResponse;
import com.example.sql.server.proxy.utils.CommonsUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
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

        BigDecimal saleCountPoprcentage = CommonsUtils.calculateSalesCountIncreasePercentage(sales);

        SalesResponseCard c3 = new SalesResponseCard();
        c3.setTitle("Cantidad total de ventas");
        c3.setValue(new BigDecimal(sales.size()));
        c3.setChangePorcentage(saleCountPoprcentage);
        c3.setSubtitle("Ultimos 30 días");

        // Cantidad total de clientes

        BigDecimal customersCountPorcentage = CommonsUtils.calculateCustomersCountIncreasePercentage(customersList);

        SalesResponseCard c4 = new SalesResponseCard();
        c4.setTitle("Cantidad total de clientes");
        c4.setValue(new BigDecimal(customersList.size()));
        c4.setChangePorcentage(customersCountPorcentage);
        c4.setSubtitle("Ultimos 30 días");

        list.add(c1);
        list.add(c3);
        list.add(c4);

        return list;
    }

    @Override
    public List<TransactionResponse> getTransactions() {
        List<TransactionResponse> listOut = new ArrayList<>();

        List<Sale> ventas =  repository.findAll();

        ventas.forEach( item ->{
            TransactionResponse trn = new TransactionResponse();
            trn.setId(item.getId());
            trn.setSaleDate(item.getSaleDate());
            trn.setReferenceNumber(item.getReferenceNumber());
            trn.setCustomerType(item.getCustomer().getCustomerType().name());
            if(item.getCustomer().getCustomerType().equals(CustomerType.F)){
                CustomerPhysical phi = (CustomerPhysical) item.getCustomer();
                String name = phi.getFirstName() + " "+ phi.getLastName();
                trn.setCustomerName(name);
            }else{
                CustomerMoral phi = (CustomerMoral) item.getCustomer();
                String name = phi.getBusinessName();
                trn.setCustomerName(name);
            }

            trn.setDescription(item.getDescription());
            trn.setProductCount(item.getSaleItemList().size());
            trn.setTotalAmount(trn.getTotalAmount());
            trn.setPaymentMethod(trn.getPaymentMethod());
            listOut.add(trn);
        });

        return listOut;
    }

}
