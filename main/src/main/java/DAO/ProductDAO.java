package DAO;


import ENTITY.Product;

import java.util.List;

public interface ProductDAO {

        void save (Product product);
        Product findByID (Long id);
        List<Product> findAll();



}
