package DAO;

import ENTITY.Category;

import java.util.List;

public interface CategoryDAO {
    void save(Category category);
    Category findByID(Long id);
    List<Category> findALL();
}
