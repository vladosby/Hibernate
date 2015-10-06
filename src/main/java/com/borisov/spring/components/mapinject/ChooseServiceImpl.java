package com.borisov.spring.components.mapinject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by User on 04.01.2015.
 */
@Service
public class ChooseServiceImpl implements ChooseService {
    @Autowired
    private Map<String, Sender> map;

    @Override
    public void choose(int numberService) {
        map.get(Integer.toString(numberService)).send();
    }
}
