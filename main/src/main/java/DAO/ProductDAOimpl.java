package DAO;

import ENTITY.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAOimpl implements ProductDAO{

    private final SessionFactory sessionFactory;

    public ProductDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Product product) {
        Session session=sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        try {
            session.save(product);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
        }


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
