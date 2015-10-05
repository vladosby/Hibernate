package com.borisov.spring.reflections;

/**
 * Created by vladosby on 04.10.2015.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RunThisMethod {
    int repeat() default 1;
}
