package SERVICE;


import DTO.ProductRequest;
import ENTITY.Product;

import java.util.List;

public interface ProductService {
    Product findByID(Long id);

    List<Product> findAll();

    List<Product> notifyLowStock();
    void createProduct(ProductRequest request);
}
