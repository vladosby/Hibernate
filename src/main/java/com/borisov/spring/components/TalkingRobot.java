package com.borisov.spring.components;

import com.borisov.spring.components.framework.RunThisMethod;
import com.borisov.spring.components.framework.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by vladosby on 04.10.2015.
 */
@Component
public class TalkingRobot implements Robot {
    @Autowired
    private List<Quoter> quoters;

//    @PostConstruct
    @Transaction
    @RunThisMethod
    @Override
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}
