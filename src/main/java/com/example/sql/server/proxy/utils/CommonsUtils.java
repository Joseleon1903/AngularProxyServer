package com.example.sql.server.proxy.utils;

import com.example.sql.server.proxy.domain.Sale;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class CommonsUtils {

    public static boolean isValidId(Long id) {
        return id != null && id > 0;
    }


    public static BigDecimal calculateSalesIncreasePercentage(List<Sale> sales) {

        if (sales == null || sales.isEmpty()) {
            return BigDecimal.ZERO;
        }

        LocalDate today = LocalDate.now();

        LocalDate currentPeriodStart = today.minusDays(29);
        LocalDate previousPeriodStart = today.minusDays(59);
        LocalDate previousPeriodEnd = today.minusDays(30);

        BigDecimal currentTotal = BigDecimal.ZERO;
        BigDecimal previousTotal = BigDecimal.ZERO;

        for (Sale sale : sales) {

            if (sale.getSaleDate() == null || sale.getTotalAmount() == null) {
                continue;
            }

            LocalDate saleDate = sale.getSaleDate();

            // Ventas de los últimos 30 días
            if (!saleDate.isBefore(currentPeriodStart) && !saleDate.isAfter(today)) {
                currentTotal = currentTotal.add(sale.getTotalAmount());
            }

            // Ventas de los 30 días anteriores
            if (!saleDate.isBefore(previousPeriodStart) && !saleDate.isAfter(previousPeriodEnd)) {
                previousTotal = previousTotal.add(sale.getTotalAmount());
            }
        }

        // Si no hubo ventas en el período anterior
        if (previousTotal.compareTo(BigDecimal.ZERO) == 0) {
            return currentTotal.compareTo(BigDecimal.ZERO) > 0
                    ? BigDecimal.valueOf(100)
                    : BigDecimal.ZERO;
        }

        return currentTotal
                .subtract(previousTotal)
                .multiply(BigDecimal.valueOf(100))
                .divide(previousTotal, 2, RoundingMode.HALF_UP);
    }

}
