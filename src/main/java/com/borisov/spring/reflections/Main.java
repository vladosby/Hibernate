package com.borisov.spring.reflections;

/**
 * Created by vladosby on 04.10.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Person person = ObjectFactory.createObject(Person.class);
    }
}
