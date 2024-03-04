package SERVICE;

import CONVERTER.ProductConverter;
import DAO.ProductDAO;
import DAO.ProductDAOimpl;
import DTO.ProductRequest;
import ENTITY.Product;
import VALIDATOR.ProductValidator;
import config.HibernateConfig;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements ProductService {
    private SessionFactory sessionFactory= HibernateConfig.getSessionFactory();
    private final ProductDAO productDAO= new ProductDAOimpl(sessionFactory);

    private final Integer limitStock = 5;
    public List<Product> notifyLowStock(){
        List<Product> products = new ArrayList<>();
        List<Product> lowStock= new ArrayList<>();
        for(Product product : products){
            if (product.getQuantity()<limitStock){
                lowStock.add(product);
                System.out.println("Produkti drejt mberimit");

            }
        }
        return lowStock;
    }

    @Override
    public void createProduct(ProductRequest request) {
        ProductValidator.validateProduct(request);
        Product product= ProductConverter.convertRequestToEntity(request);
        productDAO.save(product);
    }

    @Override
    public Product findByID(Long id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }


}
