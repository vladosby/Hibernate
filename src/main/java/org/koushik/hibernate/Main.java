package org.koushik.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.hibernate.entities.*;

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

        session = sessionFactory.openSession();
        Animal readAnimal = session.get(Animal.class, 1);
        AnimalFeed af = (AnimalFeed)readAnimal.getFeeds().toArray()[0];
        System.out.println(af.getName());
        AnimalFeed anFe = session.get(AnimalFeed.class, 5);
        System.out.println(anFe.getAnimal().getName());
//        AnimalFeed animalFeed = session.get(AnimalFeed.class, 3);
//        System.out.println(animalFeed.getAnimal().getName());
//        User readUser = session.get(User.class, 1);
        session.close();

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

        List<AnimalFeed> feeds = new ArrayList<>();
        AnimalFeed animalFeed = new AnimalFeed();
        AnimalFeed animalFeed2 = new AnimalFeed();
        animalFeed.setAnimal(animal);
        animalFeed.setName("onion");
        feeds.add(animalFeed);
        animalFeed2.setAnimal(animal);
        animalFeed2.setName("garlic");
        feeds.add(animalFeed2);

        animal.setFeeds(feeds);

        animal.setAnimalType(animalType);

        List<AnimalOwner> animalOwners = new ArrayList<>();
        AnimalOwner animalOwner = new AnimalOwner();
        animalOwner.setName("first Owner");

        AnimalOwner animalOwner2 = new AnimalOwner();
        animalOwner.setName("second Owner");
        animalOwners.add(animalOwner);
        animalOwners.add(animalOwner2);

        animal.setAnimalOwners(animalOwners);
    }
}
