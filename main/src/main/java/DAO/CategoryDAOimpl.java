package DAO;

import ENTITY.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDAOimpl implements CategoryDAO{
    private final SessionFactory sessionFactory;
    public CategoryDAOimpl (SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    public void save(Category category) {
        Session session=sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        try {
            session.save(category);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
        }


    }

    @Override
    public Category findByID(Long id) {
        return null;
    }

    @Override
    public List<Category> findALL() {
        return null;
    }
}
