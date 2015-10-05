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
public class BenchmarkBPP implements BeanPostProcessor {
    private static HashMap<String, Class> mapBeans = new HashMap<>();

//    @Autowired
//    private ConfigurableListableBeanFactory factory;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Benchmark.class)) {
                mapBeans.put(beanName, clazz);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
//        BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
//        String beanClassName = beanDefinition.getBeanClassName();
//        Class<?> aClass = Class.forName(beanClassName);

        final Class clazz = mapBeans.get(beanName);

        if(clazz != null){
            Object proxy = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Method originalMethod = clazz.getMethod(method.getName(), method.getParameterTypes());

                    if(originalMethod.isAnnotationPresent(Benchmark.class)) {
                        long before = System.nanoTime();
                        Object returnValue = method.invoke(bean, args);
                        long after = System.nanoTime();

                        System.out.println("Time of work = " + (after - before));
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
