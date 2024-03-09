package DAO;

import ENTITY.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OrderDaoIMPL implements OrderDao{
    private final SessionFactory sessionFactory;

    public OrderDaoIMPL(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    public Orders create(Orders orders) {


        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Orders response = (Orders) session.save(orders);
            transaction.commit();
            return response;
        }
    }
}
