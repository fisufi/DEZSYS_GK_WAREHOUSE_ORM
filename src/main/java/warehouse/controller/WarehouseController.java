package warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouse.model.Warehouse;
import warehouse.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public Warehouse addWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.addWarehouse(warehouse);
    }

    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @GetMapping("/{id}")
    public Warehouse getWarehouseById(@PathVariable String id) {
        return warehouseService.getWarehouseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable String id) {
        warehouseService.deleteWarehouse(id);
    }
}