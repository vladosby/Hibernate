package com.borisov.spring.components.framework;

import javassist.Loader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created by vladosby on 05.10.2015.
 */

@Component
public class WarningBeanFactoryPP implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        for (String beanDefinitionName: beanDefinitionNames){
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition)beanFactory.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getBeanClassName() != null) {
                try {
                    Class<?> aClass = Class.forName(beanDefinition.getBeanClassName());
                    Method[] methods = aClass.getMethods();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(PreDestroy.class) && beanDefinition.isPrototype()) {
                            System.out.println("destroy method " + method.getName() + " will not work in prototype: " +
                                    beanDefinitionName);
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
