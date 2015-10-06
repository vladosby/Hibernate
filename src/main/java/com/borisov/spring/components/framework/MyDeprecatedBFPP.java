package com.borisov.spring.components.framework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

import org.springframework.stereotype.Component;

/**
 * Created by vladosby on 05.10.2015.
 */
@Component
public class MyDeprecatedBFPP implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

        for(String beanDefinitionName: beanDefinitionNames){
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition)beanFactory.getBeanDefinition(beanDefinitionName);
            String originalClassName = beanDefinition.getBeanClassName();

            if(originalClassName != null) {
                changeClass(beanDefinition, originalClassName);
            }
        }
    }

    protected void changeClass(AbstractBeanDefinition beanDefinition, String originalClassName){
        try {
            Class<?> originalClass = Class.forName(originalClassName);
            MyDepricated annotation = originalClass.getAnnotation(MyDepricated.class);
            if (annotation != null) {
                Class newClass = annotation.newClass();
                beanDefinition.setBeanClassName(newClass.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
