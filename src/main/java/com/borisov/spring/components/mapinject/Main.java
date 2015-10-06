package com.borisov.spring.components.mapinject;

import com.borisov.spring.config.MapInjectjavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by User on 04.01.2015.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MapInjectjavaConfig.class);
        ChooseService bean = context.getBean(ChooseService.class);
        bean.choose(2);
    }
}
