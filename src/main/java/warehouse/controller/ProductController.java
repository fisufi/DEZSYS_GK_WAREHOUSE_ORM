// ProductController.java
package warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import warehouse.model.ProductData;
import warehouse.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ProductData getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductData> getProducts(
            @RequestParam(required = false) String warehouseID,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) Double productQuantity,
            @RequestParam(required = false) List<String> productCategory) {

        if (warehouseID != null && productName != null) {
            return productService.getProductsByWarehouseIDAndProductName(warehouseID, productName);
        } else if (productQuantity != null) {
            if (warehouseID != null) {
                return productService.getProductsByWarehouseIDAndProductQuantityLessThanEqual(warehouseID, productQuantity);
            } else {
                return productService.getProductsByProductQuantityLessThanEqual(productQuantity);
            }
        } else if (productCategory != null && !productCategory.isEmpty()) {
            return productService.getProductsByProductCategoryIn(productCategory);
        } else if (warehouseID != null) {
            return productService.getProductsByWarehouseID(warehouseID);
        } else {
            return productService.getAllProducts();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Other CRUD methods...

}