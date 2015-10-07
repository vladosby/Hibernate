package com.borisov.spring.components.problemPrototype;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vladosby on 07.01.2015.
 */
public class SecondClass implements ClassInterface {
    @Autowired
    private Assistant assistent;
    @Override
    public void execute() {
        System.out.println("I am Second Class");
        assistent.print();
    }
}
