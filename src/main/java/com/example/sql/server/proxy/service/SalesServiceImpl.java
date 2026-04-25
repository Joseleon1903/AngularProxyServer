package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.response.SalesResponseCard;
import com.example.sql.server.proxy.response.TransactionResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService{


    @Override
    public List<SalesResponseCard> getSalesResponseCard() {
        List<SalesResponseCard> list = new ArrayList<>();

        SalesResponseCard c1 = new SalesResponseCard();
        c1.setTitle("Ingresos");
        c1.setValue(new BigDecimal("150000"));
        c1.setChangePorcentage(new BigDecimal("12.5"));
        c1.setUrlIcon("fas fa-dollar-sign");

        SalesResponseCard c2 = new SalesResponseCard();
        c2.setTitle("Ventas");
        c2.setValue(new BigDecimal("320"));
        c2.setChangePorcentage(new BigDecimal("8.3"));
        c2.setUrlIcon("fas fa-shopping-cart");

        SalesResponseCard c3 = new SalesResponseCard();
        c3.setTitle("Órdenes");
        c3.setValue(new BigDecimal("89"));
        c3.setChangePorcentage(new BigDecimal("-2.4"));
        c3.setUrlIcon("fas fa-receipt");

        SalesResponseCard c4 = new SalesResponseCard();
        c4.setTitle("Clientes");
        c4.setValue(new BigDecimal("120"));
        c4.setChangePorcentage(new BigDecimal("5.6"));
        c4.setUrlIcon("fas fa-users");

        list.add(c1);
        list.add(c2);
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
