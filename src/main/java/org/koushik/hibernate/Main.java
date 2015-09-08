package org.koushik.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.hibernate.entities.User;

/**
 * Created by vladosby on 06.09.2015.
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("First User");

        User user2 = new User();
        user2.setName("Second User");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(user2);
        session.getTransaction().commit();
        session.close();
    }
}
