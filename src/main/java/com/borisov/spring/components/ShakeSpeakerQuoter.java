package com.borisov.spring.components;

import com.borisov.spring.components.framework.Benchmark;
import com.borisov.spring.components.framework.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by vladosby on 04.10.2015.
 */
@Component
public class ShakeSpeakerQuoter implements Quoter {
    @Value("I am bean!")
    private String message;

    private List<String> messages;

    @Transaction
    @Benchmark
    @Override
    public void sayQuote() {
        System.out.println(message);
    }

    @PostConstruct
    public void init(){
        System.out.println("Init method is running...");
    }
}
