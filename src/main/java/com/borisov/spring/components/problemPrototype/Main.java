package com.borisov.spring.components.problemPrototype;

import com.borisov.spring.config.PrototypeProblemJavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by vladosby on 07.01.2015.
 */
public class Main {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrototypeProblemJavaConfig.class);
        ClassInterface firstClass = (ClassInterface) context.getBean("firstClass");
        ClassInterface secondClass = (ClassInterface) context.getBean("secondClass");

        firstClass.execute();
        firstClass.execute();
        firstClass.execute();
        firstClass.execute();
        secondClass.execute();

    }


}
