// ProductDataRepository.java
package warehouse.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import warehouse.model.ProductData;

import java.util.List;

@Repository
public interface ProductDataRepository extends MongoRepository<ProductData, String> {

    ProductData findByProductID(String productID);
    List<ProductData> findByWarehouseID(String warehouseID);

    @Query("{ 'warehouseID': ?0, 'productName': ?1 }")
    List<ProductData> findByWarehouseIDAndProductName(String warehouseID, String productName);

    @Query("{ 'productQuantity': { $lte: ?0 } }")
    List<ProductData> findByProductQuantityLessThanEqual(Double productQuantity);

    @Query("{ 'warehouseID': ?0, 'productQuantity': { $lte: ?1 } }")
    List<ProductData> findByWarehouseIDAndProductQuantityLessThanEqual(String warehouseID, Double productQuantity);

    @Query("{ 'productCategory': { $in: ?0 } }")
    List<ProductData> findByProductCategoryIn(List<String> productCategories);
}