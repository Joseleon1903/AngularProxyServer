package com.example.sql.server.proxy.process;

import com.example.sql.server.proxy.domain.Inventory;
import com.example.sql.server.proxy.domain.Sale;
import com.example.sql.server.proxy.domain.SystemExecuteLog;
import com.example.sql.server.proxy.repository.InventoryRepository;
import com.example.sql.server.proxy.repository.ProductRepository;
import com.example.sql.server.proxy.repository.SystemExecuteLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProcesarVentaService implements Proceso{

    private final SystemExecuteLogRepository systemExecuteLogRepository;

    private final InventoryRepository inventoryRepository;

    private final ProductRepository productRepository;

    @Autowired
    public ProcesarVentaService(SystemExecuteLogRepository systemExecuteLogRepository, InventoryRepository inventoryRepository, ProductRepository productRepository) {
        this.systemExecuteLogRepository = systemExecuteLogRepository;
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
    }

    /*
           Paso 1
              registrar una ejecucion del proceso en la tabla de SystemExecuteLog

           Paso 2
              recorrer los productos asociados a la venta y actualiz los inventario de cada producto
              restandole la cantidad de productos vendidos
                  ejemplo
                    Venta --> cantidad 5 bizcochitos
                    busco inventario de bizcochitos
                    actualizo el Stock de los bizscochitos(currentStock) de cada inventario (-=5)

         */
    @Override
    public void procesarVenta(Sale venta) {

        // paso 1
        SystemExecuteLog systemExecuteLog = new SystemExecuteLog();

        systemExecuteLog.setProcessName("Sincronización de Inventario");
        systemExecuteLog.setProcessCode("SYNC_INV");
        systemExecuteLog.setExecutionId(UUID.randomUUID());
        systemExecuteLog.setStatus("SUCCESS");
        systemExecuteLog.setValue("Proceso de venta id : "+venta.getId());
        systemExecuteLog.setExecuteDateStart(LocalDateTime.now());
        systemExecuteLog.setExecuteDateEnd(LocalDateTime.now());
        systemExecuteLog.setExecutedBy("ADMIN");
        systemExecuteLog.setHostName("DESKTOP-01");
        systemExecuteLog.setApplicationName("CoreBake");
        systemExecuteLogRepository.save(systemExecuteLog);
        System.out.println("paso 1 exitoso..");
        // paso 2
        venta.getSaleItemList().forEach(item ->{
            System.out.println("buscando sale item: "+item.getSaleItemId());

            List<Inventory> inventarios = inventoryRepository.findByProductId(item.getProductId()).get();

            for (Inventory inv : inventarios) {
                System.out.println("Inventario Id encontrado : "+inv.getId());
                int currentStock = inv.getCurrentStock();
                currentStock -= item.getQuantity();
                inv.setCurrentStock(currentStock);
                System.out.println("update CurrentStock : "+inv.getCurrentStock());
                inventoryRepository.save(inv);
            }
        });

    }
}
