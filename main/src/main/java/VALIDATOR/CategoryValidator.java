package VALIDATOR;

import DTO.CategoryRequest;
import DTO.ProductRequest;

public class CategoryValidator {
    public static void validateCategory(CategoryRequest categoryRequest){
        if (categoryRequest.getTitle().isEmpty() || categoryRequest.getId()==0 ) {
            throw new IllegalArgumentException();
        }
    }
}
