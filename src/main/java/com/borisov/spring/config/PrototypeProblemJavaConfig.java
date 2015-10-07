package com.borisov.spring.config;

import com.borisov.spring.components.problemPrototype.Assistant;
import com.borisov.spring.components.problemPrototype.ClassPrototype;
import com.borisov.spring.components.problemPrototype.FirstClass;
import com.borisov.spring.components.problemPrototype.SecondClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by vladosby on 07.01.2015.
 */
@Configuration
@ComponentScan(basePackages = "xom.borisov.component.problemPrototype")
public class PrototypeProblemJavaConfig {
    @Bean
    public FirstClass firstClass() {
        return new FirstClass();
    }

    @Bean
    public SecondClass secondClass() {
        return new SecondClass();
    }

    @Bean
    public Assistant assistant() {

        return new Assistant() {
            @Override
            public void print() {
                classPrototype().doSomething();
            }
        };
    }

    @Bean
    @Scope("prototype")
    public ClassPrototype classPrototype() {
        return new ClassPrototype();
    }

}
