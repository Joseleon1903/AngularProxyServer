package com.example.sql.server.proxy.controller;

import com.example.sql.server.proxy.domain.Sale;
import com.example.sql.server.proxy.process.ProcesarVentaService;
import com.example.sql.server.proxy.request.CreateSaleRequest;
import com.example.sql.server.proxy.response.SalesResponseCard;
import com.example.sql.server.proxy.response.TransactionResponse;
import com.example.sql.server.proxy.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService service;

    private final ProcesarVentaService procesarVentaService;


    public SaleController(SaleService service, ProcesarVentaService procesarVentaService) {
        this.service = service;
        this.procesarVentaService = procesarVentaService;
    }

    // GET: listar todas
    @GetMapping
    public List<Sale> getAll() {
        return service.findAll();
    }

    // GET: obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<Sale> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: crear venta
    @PostMapping
    public ResponseEntity<Sale> create(@RequestBody CreateSaleRequest sale) {
        System.out.println("entering in create sale ");
        System.out.println("input "+ sale);

        Sale saleOut = service.createSale(sale);

        System.out.println("llamada procesarVenta");
        procesarVentaService.procesarVenta(saleOut);

        return ResponseEntity.ok(saleOut);
    }

    // PUT: actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Sale> update(@PathVariable Long id, @RequestBody Sale sale) {
        return ResponseEntity.ok(service.update(id, sale));
    }

    // DELETE: eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ============================
    // GET ALL Sales
    // ============================
    @GetMapping("/summary-cards")
    public ResponseEntity<List<SalesResponseCard>> getSummaryCards() {
        return ResponseEntity.ok(service.getSalesResponseCard());
    }

    // ============================
    // GET ALL Transaction
    // ============================
    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionResponse>> getSales() {
        return ResponseEntity.ok(service.getTransactions());
    }


}
