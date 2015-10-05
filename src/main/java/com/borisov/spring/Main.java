package com.borisov.spring;

import com.borisov.spring.components.Quoter;
import com.borisov.spring.components.Robot;
import com.borisov.spring.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Created by vladosby on 04.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.getBean("prototypeClass");
//        quoter.sayQuote();
//        quoter.talk();
//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//
//        System.out.println(Arrays.asList(beanDefinitionNames));
    }
}
