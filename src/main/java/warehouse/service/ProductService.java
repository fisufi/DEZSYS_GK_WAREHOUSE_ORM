// ProductService.java
package warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.model.ProductData;
import warehouse.model.Warehouse;
import warehouse.repository.ProductDataRepository;
import warehouse.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductDataRepository productDataRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    public ProductData addProduct(ProductData product) {
        return productDataRepository.save(product);
    }

    public List<ProductData> getAllProducts() {
        return productDataRepository.findAll();
    }

    public ProductData getProductById(String id) {
        return productDataRepository.findById(id).orElse(null);
    }

    public void deleteProduct(String id) {
        ProductData product = getProductById(id);
        if (product != null) {
            List<Warehouse> warehouses = warehouseRepository.findAll();
            for (Warehouse warehouse : warehouses) {
                warehouse.getInventory().removeIf(p -> p.getProductID().equals(id));
                warehouseRepository.save(warehouse);
            }
            productDataRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product not found with ID: " + id);
        }
    }

    public List<ProductData> getProductsByWarehouseID(String warehouseID) {
        return productDataRepository.findByWarehouseID(warehouseID);
    }

    public List<ProductData> getProductsByWarehouseIDAndProductName(String warehouseID, String productName) {
        return productDataRepository.findByWarehouseIDAndProductName(warehouseID, productName);
    }

    public List<ProductData> getProductsByProductQuantityLessThanEqual(Double productQuantity) {
        return productDataRepository.findByProductQuantityLessThanEqual(productQuantity);
    }

    public List<ProductData> getProductsByWarehouseIDAndProductQuantityLessThanEqual(String warehouseID, Double productQuantity) {
        return productDataRepository.findByWarehouseIDAndProductQuantityLessThanEqual(warehouseID, productQuantity);
    }

    public List<ProductData> getProductsByProductCategoryIn(List<String> productCategories) {
        return productDataRepository.findByProductCategoryIn(productCategories);
    }

    public void deleteProductById(String id) {
        productDataRepository.deleteById(id);
    }

}