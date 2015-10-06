package com.borisov.spring.components.dependson;

import com.borisov.spring.config.DependsOnJavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by vladosby on 06.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(DependsOnJavaConfig.class);
    }
}
