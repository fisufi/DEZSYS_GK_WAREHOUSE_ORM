package warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.model.ProductData;
import warehouse.repository.ProductDataRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDataRepository productDataRepository;

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
        productDataRepository.deleteById(id);
    }
}