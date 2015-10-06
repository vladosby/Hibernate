package com.borisov.spring.components.dependson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * Created by vladosby on 06.10.2015.
 */
@Component
@DependsOn("fileCreatorImpl")
public class FileHandlerImpl implements FileHandler {
    @Override
    @Value("${file}")
    public void printPathInfo(String filePath) {
        File file = new File(filePath);
        System.out.println(file.length());
    }
}
