package warehouse.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import warehouse.model.ProductData;

public interface ProductDataRepository extends MongoRepository<ProductData, String> {

    public ProductData findByProductID(String productID);
    public List<ProductData> findByWarehouseID(String warehouseID);
}