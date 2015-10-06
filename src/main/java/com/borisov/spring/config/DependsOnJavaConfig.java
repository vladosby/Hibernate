package com.borisov.spring.config;

import com.borisov.spring.components.framework.Benchmark;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by vladosby on 06.10.2015.
 */

@Configuration
@ComponentScan(basePackages = {"com.borisov.spring.components.dependson"})
@PropertySource("classpath:files.properties")
public class DependsOnJavaConfig {
    @Bean
    public PropertySourcesPlaceholderConfigurer configurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
