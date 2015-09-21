package org.koushik.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.hibernate.entities.Address;
import org.koushik.hibernate.entities.Animal;
import org.koushik.hibernate.entities.AnimalType;
import org.koushik.hibernate.entities.User;

import java.util.*;

/**
 * Created by vladosby on 06.09.2015.
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        fillUser(user);

        Animal animal = new Animal();
        fillAnimal(animal);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        session.save(user);
        session.save(animal);
        session.getTransaction().commit();
        session.close();

//        session = sessionFactory.openSession();
//        User readUser = session.get(User.class, 1);
//        session.close();

//        System.out.println(readUser.getAddresses().size());
        sessionFactory.close();
    }

    public static void fillUser(User user){
        user.setName("First User");

        Address address = new Address();
        address.setCity("City1");
        address.setStreet("Street1");

        Address address2 = new Address();
        address2.setCity("City2");
        address2.setStreet("Street2");

        user.setAddresses(new ArrayList<>(Arrays.asList(address,address2)));
    }

    public static void fillAnimal(Animal animal){
        animal.setName("First Animal");

        AnimalType animalType = new AnimalType();
        animalType.setType("Type 1");

        animal.setAnimalType(animalType);
    }
}
