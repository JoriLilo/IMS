package CONVERTER;

import DTO.CategoryRequest;
import ENTITY.Category;

public class CategoryConverter {
    public static Category convertCategRequestToEntity(CategoryRequest categoryRequest){
        Category category=new Category();
        category.setId(categoryRequest.getId());
        category.setTitle(categoryRequest.getTitle());
        category.setCreatedAt(categoryRequest.getCreatedAt());
        category.setUpdatedAt(categoryRequest.getUpdatedAt());

        return category;
    }
}
