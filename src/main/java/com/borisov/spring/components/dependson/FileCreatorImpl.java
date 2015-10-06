package com.borisov.spring.components.dependson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Created by vladosby on 06.10.2015.
 */

@Component
public class FileCreatorImpl implements FileCreator {
    @Override
    @Value("${file}")
    public void createFile(String filePath) {
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("File Created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
