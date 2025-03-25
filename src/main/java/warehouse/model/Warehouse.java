package warehouse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "warehouses")
public class Warehouse {

    @Id
    private String id;
    private String warehouseName;
    private String timestamp;
    private String warehousePostalCode;
    private String warehouseCity;
    private String warehouseCountry;
    private List<ProductData> inventory;

    // Default constructor

    public Warehouse() {
    }

    // Constructor with parameters
    public Warehouse(String id, String warehouseName, String location, String warehousePostalCode, String warehouseCity, String warehouseCountry) {
        this.id = id;
        this.warehouseName = warehouseName;
        this.warehousePostalCode = warehousePostalCode;
        this.warehouseCity = warehouseCity;
        this.warehouseCountry = warehouseCountry;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProductData> getInventory() {
        return inventory;
    }

    public void setInventory(List<ProductData> inventory) {
        this.inventory = inventory;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getWarehousePostalCode() {
        return warehousePostalCode;
    }

    public void setWarehousePostalCode(String warehousePostalCode) {
        this.warehousePostalCode = warehousePostalCode;
    }

    public String getWarehouseCity() {
        return warehouseCity;
    }

    public void setWarehouseCity(String warehouseCity) {
        this.warehouseCity = warehouseCity;
    }

    public String getWarehouseCountry() {
        return warehouseCountry;
    }

    public void setWarehouseCountry(String warehouseCountry) {
        this.warehouseCountry = warehouseCountry;
    }
}