package com.borisov.spring.components.framework;

import com.borisov.spring.components.T1000;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.LookupOverride;
import org.springframework.beans.factory.support.MethodOverride;
import org.springframework.beans.factory.support.MethodOverrides;
import org.springframework.core.type.StandardMethodMetadata;
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
            } else {
                StandardMethodMetadata source = (StandardMethodMetadata) beanDefinition.getSource();
                String returnTypeName = source.getReturnTypeName();
                if(returnTypeName != null){
                    try {
                        Class<?> originalClass = Class.forName(returnTypeName);
                        MyDepricated annotation = originalClass.getAnnotation(MyDepricated.class);
                        if (annotation != null) {
                            Class newClass = annotation.newClass();
//                            beanDefinition.set(newClass.getName());
//                            beanFactory.getParentBeanFactory()
//                            beanDefinition.getDestroyMethodName()
                            MethodOverrides methodOverrides = beanDefinition.getMethodOverrides();
                            LookupOverride lookupOverride = new LookupOverride(beanDefinitionName, source.getDeclaringClassName());
                            lookupOverride.setSource(T1000.class);
                            methodOverrides.addOverride(lookupOverride);
//                            MethodOverride methodOverride = new MethodOverride();
//                            methodOverrides.addOverride();
//                            beanDefinition.setMethodOverrides();
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
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
