package com.borisov.spring.components.framework;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * Created by vladosby on 04.10.2015.
 */

@Component
public class TransactionBPP implements BeanPostProcessor {
    private HashMap<String, Class> mapBeans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Transaction.class)) {
                mapBeans.put(beanName, clazz);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        final Class clazz = mapBeans.get(beanName);

        if(clazz != null){
            Object proxy = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Method originalMethod = clazz.getMethod(method.getName(), method.getParameterTypes());

                    if (originalMethod.isAnnotationPresent(Transaction.class)) {
                        System.out.println("start transaction");
                        Object returnValue = method.invoke(bean, args);
                        System.out.println("finish transaction");

                        return returnValue;
                    } else {
                        return method.invoke(bean, args);
                    }
                }
            });

            return proxy;
        } else {
            return bean;
        }

    }
}
