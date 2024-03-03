package CONVERTER;

import DTO.ProductRequest;
import ENTITY.Category;
import ENTITY.Product;

public class ProductConverter {
    public static Product convertRequestToEntity(ProductRequest request) {
        Product product = new Product();
        product.setCategory(new Category(request.getCategory()));
        product.setDescription(request.getDescription());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());
        product.setTitle(request.getTitle());

        return product;

    }
}
