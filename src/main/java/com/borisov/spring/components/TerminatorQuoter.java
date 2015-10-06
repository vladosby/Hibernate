package com.borisov.spring.components;

import com.borisov.spring.components.framework.MyDepricated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by vladosby on 04.10.2015.
 */
@Component
@MyDepricated(newClass = T1000.class)
public class TerminatorQuoter implements Quoter {
//    private List<String> quotes;

    //List doesn't work with it, you need to write:
    //@Value("${terminatorQuotes}")
    //public void setQuotes(String[] quotes) {
    //      this.quotes = Arrays.asList(quotes);
    //}
    //
    @Value("${terminatorQuotes}")
    private String[] quotes;

//    public List<String> getQuotes() {
//        return quotes;
//    }
//
//    public void setQuotes(List<String> quotes) {
//        this.quotes = quotes;
//    }

    @Override
    public void sayQuote() {
//        quotes.forEach(System.out::println);
        for (String qoute: quotes){
            System.out.println(qoute);
        }
    }
}
