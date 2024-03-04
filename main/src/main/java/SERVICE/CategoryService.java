package SERVICE;

import DTO.CategoryRequest;
import ENTITY.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Long id);
    List<Category> findAll();

    void createCategory(CategoryRequest categoryRequest);
}
