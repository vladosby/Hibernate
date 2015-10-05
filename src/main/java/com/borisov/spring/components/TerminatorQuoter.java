package com.borisov.spring.components;

import com.borisov.spring.components.framework.MyDepricated;

import java.util.List;

/**
 * Created by vladosby on 04.10.2015.
 */
//@Component
@MyDepricated(newClass = T1000.class)
public class TerminatorQuoter implements Quoter {
    //    @Autowired
    private List<String> quotes;

    public List<String> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }

    @Override
    public void sayQuote() {
        quotes.forEach(System.out::println);
    }
}
