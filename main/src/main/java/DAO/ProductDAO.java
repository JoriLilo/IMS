package DAO;


import ENTITY.Product;
import org.hibernate.Session;

import java.util.List;

public interface ProductDAO {

        void save (Product product);
        Product findByID (Long id);
        List<Product> findAll();

        List<Product> findAllByIds(List<Long> ids);




}
