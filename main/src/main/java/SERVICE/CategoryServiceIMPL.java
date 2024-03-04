package SERVICE;

import CONVERTER.CategoryConverter;
import DAO.CategoryDAO;
import DAO.CategoryDAOimpl;
import DTO.CategoryRequest;
import ENTITY.Category;
import VALIDATOR.CategoryValidator;
import config.HibernateConfig;
import org.hibernate.SessionFactory;

import java.util.List;

public class CategoryServiceIMPL implements CategoryService{
    private SessionFactory sessionFactory= HibernateConfig.getSessionFactory();

    private final CategoryDAO categoryDAO=new CategoryDAOimpl(sessionFactory);
    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public void createCategory(CategoryRequest categoryRequest) {
        CategoryValidator.validateCategory(categoryRequest);
        Category category= CategoryConverter.convertCategRequestToEntity(categoryRequest);
        categoryDAO.save(category);

    }


}
