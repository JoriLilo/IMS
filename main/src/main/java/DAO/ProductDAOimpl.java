package DAO;

import ENTITY.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


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
    public List<Product> findAllByIds(List<Long> ids) {
        Session session=sessionFactory.openSession();
        Query<Product> query = session.createQuery("from Product where id in (:ids)" ,Product.class);
        query.setParameter("ids",ids);
        return query.getResultList();
    }

    @Override
    public Product findByID(Long id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        Session session=sessionFactory.openSession();
        return session.createQuery("SELECT a FROM Product a", Product.class).getResultList();
    }
}
