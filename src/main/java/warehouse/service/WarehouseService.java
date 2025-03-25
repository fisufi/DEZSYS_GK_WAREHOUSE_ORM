// WarehouseService.java
package warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.model.Warehouse;
import warehouse.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    private ProductService productService;

    @Autowired
    private WarehouseRepository warehouseRepository;

    public Warehouse addWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public List<Warehouse> getAllWarehouses() {
        List<Warehouse> warehouses = warehouseRepository.findAll();
        for (Warehouse warehouse : warehouses) {
            String id = warehouse.getId();
            warehouse.setInventory(productService.getProductsByWarehouseID(id));
        }
        return warehouses;
    }

    public Warehouse getWarehouseById(String id) {
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(id);
        if (warehouseOptional.isEmpty()) {
            return null;
        }
        Warehouse warehouse = warehouseOptional.get();
        warehouse.setInventory(productService.getProductsByWarehouseID(id));
        warehouse.getId();
        warehouse.getWarehouseCity();
        return warehouse;
    }

    public void deleteWarehouse(String id) {
        warehouseRepository.deleteById(id);
    }
}