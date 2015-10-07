package com.borisov.spring.components.problemPrototype;

/**
 * Created by vladosby on 07.01.2015.
 */
public class ClassPrototype {
    private boolean check = false;

    public void doSomething() {
        if (check == true) {
            System.out.println("I has already used");
        } else {
            check = true;
            System.out.println("I use first time");
        }
    }
}
