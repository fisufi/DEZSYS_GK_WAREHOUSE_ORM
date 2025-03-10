package warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.model.Warehouse;
import warehouse.repository.WarehouseRepository;

import java.util.List;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public Warehouse addWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Warehouse getWarehouseById(String id) {
        return warehouseRepository.findById(id).orElse(null);
    }

    public void deleteWarehouse(String id) {
        warehouseRepository.deleteById(id);
    }
}