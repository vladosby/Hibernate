package com.borisov.spring.config;

import com.borisov.spring.components.Quoter;
import com.borisov.spring.components.TerminatorQuoter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by vladosby on 04.10.2015.
 */
@Configuration
@ComponentScan(basePackages = "com.borisov.spring.components")
public class AppConfig {
    @Bean
    public String string(){
        return "I am String bean";
    }

    @Bean
    public TerminatorQuoter terminatorQuoter(){
        TerminatorQuoter terminatorQuoter = new TerminatorQuoter();
        List<String> quotes = new ArrayList<>();
        quotes.add("I'll be back");
        quotes.add("I am terminator");
//        quotes.add(string());
        terminatorQuoter.setQuotes(quotes);

        return terminatorQuoter;
    }
}
