package com.borisov.spring.components.mapinject;

import org.springframework.stereotype.Service;

/**
 * Created by User on 04.01.2015.
 */
@Service("1")
public class HelloSender implements Sender {
    @Override
    public void send() {
        System.out.println("Hello");
    }
}
