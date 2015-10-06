package com.borisov.spring.components.mapinject;

import org.springframework.stereotype.Service;

/**
 * Created by User on 04.01.2015.
 */
@Service("2")
public class ByeSender implements Sender {
    @Override
    public void send() {
        System.out.println("Bye");
    }
}
