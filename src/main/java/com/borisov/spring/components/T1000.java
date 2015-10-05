package com.borisov.spring.components;

/**
 * Created by vladosby on 05.10.2015.
 */
public class T1000 extends TerminatorQuoter {

    @Override
    public void sayQuote() {
        System.out.println("I am T1000");
        super.sayQuote();
    }
}
