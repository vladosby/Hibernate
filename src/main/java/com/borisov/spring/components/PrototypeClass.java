package com.borisov.spring.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by vladosby on 05.10.2015.
 */
@Component
@Scope(scopeName = "prototype")
public class PrototypeClass {

    @PostConstruct
    public void init(){
        System.out.println("Init method of prototype");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroy method of prototype");
    }
}
