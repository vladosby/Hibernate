package org.koushik.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.hibernate.entities.Address;
import org.koushik.hibernate.entities.User;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
//import java.nio.file.Paths;

/**
 * Created by vladosby on 06.09.2015.
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("First User");
//
//        User user2 = new User();
//        user2.setName("Second User");
        Address address = new Address();
        address.setCity("City1");
        address.setStreet("Street1");

        Address address2 = new Address();
        address2.setCity("City2");
        address2.setStreet("Street2");

        user.setAddresses(new ArrayList<>(Arrays.asList(address,address2)));

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
//        session.save(user2);
        session.getTransaction().commit();
        session.close();

    }
}
