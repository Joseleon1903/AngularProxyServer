package com.example.sql.server.proxy.service;

import com.example.sql.server.proxy.response.SalesResponse;
import com.example.sql.server.proxy.response.SummaryResponseCard;
import com.example.sql.server.proxy.response.TopSellerProductResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OverviewServiceImpl  implements OverviewService{

    @Override
    public List<SummaryResponseCard> getSummaryCards() {
        List<SummaryResponseCard> list = new ArrayList<>();

        SummaryResponseCard card1 = new SummaryResponseCard();
        card1.setTitle("Ventas Totales");
        card1.setValue(150000);
        card1.setPorcentageCahnge(new BigDecimal("12.5"));
        card1.setIconUrl("https://tse4.mm.bing.net/th/id/OIP.TA_nQhH4TsIMT8FmpJARNwHaHa?rs=1&pid=ImgDetMain&o=7&rm=3");
        card1.setPositive(true);

        SummaryResponseCard card2 = new SummaryResponseCard();
        card2.setTitle("Usuarios Nuevos");
        card2.setValue(320);
        card2.setPorcentageCahnge(new BigDecimal("8.2"));
        card2.setIconUrl("https://cdn-icons-png.flaticon.com/512/9362/9362298.png");
        card2.setPositive(true);

        SummaryResponseCard card3 = new SummaryResponseCard();
        card3.setTitle("Órdenes");
        card3.setValue(89);
        card3.setPorcentageCahnge(new BigDecimal("-3.4"));
        card3.setIconUrl("https://cdn-icons-png.flaticon.com/512/5778/5778063.png");
        card3.setPositive(false);

        SummaryResponseCard card4 = new SummaryResponseCard();
        card4.setTitle("Ingresos Netos");
        card4.setValue(95000);
        card4.setPorcentageCahnge(new BigDecimal("5.1"));
        card4.setIconUrl("https://static.vecteezy.com/system/resources/previews/004/398/541/original/cost-reduction-flat-style-icon-isolated-on-white-background-vector.jpg");
        card4.setPositive(true);

        list.add(card1);
        list.add(card2);
        list.add(card3);
        list.add(card4);

        return list;
    }

    @Override
    public List<SalesResponse> getSales() {
        List<SalesResponse> list = new ArrayList<>();

        SalesResponse sale1 = new SalesResponse();
        sale1.setCustomerName("Juan Pérez");
        sale1.setStatus("Completado");
        sale1.setDate("15/04/2026");
        sale1.setAmount(new BigDecimal("2.5"));

        SalesResponse sale2 = new SalesResponse();
        sale2.setCustomerName("María Gómez");
        sale2.setStatus("Pendiente");
        sale2.setDate("16/04/2026");
        sale2.setAmount(new BigDecimal("1.2"));

        SalesResponse sale3 = new SalesResponse();
        sale3.setCustomerName("Carlos López");
        sale3.setStatus("Cancelado");
        sale3.setDate("17/04/2026");
        sale3.setAmount(new BigDecimal("3.80"));

        SalesResponse sale4 = new SalesResponse();
        sale4.setCustomerName("Ana Martínez");
        sale4.setStatus("Completado");
        sale4.setDate("18/04/2026");
        sale4.setAmount(new BigDecimal("9.50"));

        list.add(sale1);
        list.add(sale2);
        list.add(sale3);
        list.add(sale4);

        return list;
    }

    @Override
    public List<TopSellerProductResponse> getTopSellerProduct() {
        List<TopSellerProductResponse> list = new ArrayList<>();

        TopSellerProductResponse p1 = new TopSellerProductResponse();
        p1.setName("Pan Integral");
        p1.setCategoryName("Panadería");
        p1.setAmount(new BigDecimal("45.00"));
        p1.setImageUrl("https://misrecetasdecocina.net/wp-content/uploads/2018/01/Pan-integral-casero.jpg");

        TopSellerProductResponse p2 = new TopSellerProductResponse();
        p2.setName("Croissant");
        p2.setCategoryName("Panadería");
        p2.setAmount(new BigDecimal("60.00"));
        p2.setImageUrl("https://thumbs.dreamstime.com/b/freshly-baked-croissant-golden-glossy-finish-flaky-layers-resting-wooden-table-background-shows-cozy-sunny-320192204.jpg");

        TopSellerProductResponse p3 = new TopSellerProductResponse();
        p3.setName("Pastel de Chocolate");
        p3.setCategoryName("Repostería");
        p3.setAmount(new BigDecimal("250.00"));
        p3.setImageUrl("https://tse4.mm.bing.net/th/id/OIP.OjDpD6zNrSCnwQevkVqp9wHaEK?pid=Api&h=220&P=0");

        TopSellerProductResponse p4 = new TopSellerProductResponse();
        p4.setName("Galletas");
        p4.setCategoryName("Repostería");
        p4.setAmount(new BigDecimal("80.00"));
        p4.setImageUrl("https://tse3.mm.bing.net/th/id/OIP.3lZN1O6LZ_7hm6NB6GyTcwHaHa?pid=Api&h=220&P=0");

        TopSellerProductResponse p5 = new TopSellerProductResponse();
        p5.setName("Jugo de Naranja");
        p5.setCategoryName("Bebidas");
        p5.setAmount(new BigDecimal("70.00"));
        p5.setImageUrl("https://tse4.mm.bing.net/th/id/OIP.J2iityqfqnh1rws40sE__AHaHa?pid=Api&h=220&P=0");

        TopSellerProductResponse p6 = new TopSellerProductResponse();
        p6.setName("Café");
        p6.setCategoryName("Bebidas");
        p6.setAmount(new BigDecimal("55.00"));
        p6.setImageUrl("https://tse4.mm.bing.net/th/id/OIP.lAoQR4E1LPodW8jkFjGPKAHaE8?pid=Api&h=220&P=0");

        TopSellerProductResponse p7 = new TopSellerProductResponse();
        p7.setName("Empanada");
        p7.setCategoryName("Snacks");
        p7.setAmount(new BigDecimal("65.00"));
        p7.setImageUrl("images/empanada.png");

        TopSellerProductResponse p8 = new TopSellerProductResponse();
        p8.setName("Sandwich");
        p8.setCategoryName("Comida Rápida");
        p8.setAmount(new BigDecimal("120.00"));
        p8.setImageUrl("https://tse4.mm.bing.net/th/id/OIP.WBxDustvT_5mAr7WoodYtgHaHa?pid=Api&h=220&P=0");

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);

        return list;
    }
}
