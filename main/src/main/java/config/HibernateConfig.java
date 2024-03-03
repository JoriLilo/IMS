package config;
import ENTITY.Category;
import ENTITY.Product;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateConfig {
    @Getter
    private static SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Category.class)
                    .addAnnotatedClass(Product.class)
                    .buildSessionFactory();
        }catch (ExceptionInInitializerError eiie) {
            System.out.println(eiie.getLocalizedMessage());
            throw new ExceptionInInitializerError();
        }
    }

    public static void shutDown() {
        buildSessionFactory().close();
    }
}