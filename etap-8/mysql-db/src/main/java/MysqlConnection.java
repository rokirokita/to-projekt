import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class MysqlConnection {
    private EntityManager entityManager;
    public MysqlConnection() {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Border.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Religion.class)
                .buildSessionFactory();
        Session session = factory.openSession();
        entityManager = factory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
