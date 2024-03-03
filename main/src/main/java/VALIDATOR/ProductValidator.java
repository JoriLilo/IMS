package VALIDATOR;

import DTO.ProductRequest;

public class ProductValidator {
    public static void validateProduct(ProductRequest request) {
        if(request.getTitle().isEmpty() || request.getPrice()=='0'
                || request.getQuantity() == 0) {
            throw new IllegalArgumentException();
        }

    }
}
