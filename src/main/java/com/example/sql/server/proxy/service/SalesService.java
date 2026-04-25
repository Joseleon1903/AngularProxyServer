package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.response.SalesResponseCard;
import com.example.sql.server.proxy.response.TransactionResponse;

import java.util.List;

public interface SalesService {

    List<SalesResponseCard> getSalesResponseCard();

    List<TransactionResponse> getTransactions();

}
