package com.borisov.spring.config;

import com.borisov.spring.components.TerminatorQuoter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladosby on 04.10.2015.
 */
@Configuration
@ComponentScan(basePackages = "com.borisov.spring.components")
@PropertySource("classpath:quoter.properties")
@PropertySource("classpath:spring.properties")
public class AppConfig {
    @Bean
    public String string(@Value("${name}") String name){
        return name;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
