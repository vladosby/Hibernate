package com.borisov.spring.components.framework;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by vladosby on 05.10.2015.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyDepricated {
    Class newClass();
}
