package org.hystudio.httpframework.framework;

import org.hystudio.httpframework.utils.ClassUtil;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HttpRequestProxy implements MethodInterceptor {
    private static final Set<String> baseMethod = new HashSet<>(Arrays.asList("toString", "hashCode", "equals", "clone"));
    public static HttpRequestProxy httpRequestProxy = new HttpRequestProxy();

    public static Object createProxy(BeanDefinition beanDefinition) {
        try {
            Class clazz = Class.forName(beanDefinition.getBeanClassName());
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(clazz);
            enhancer.setCallback(httpRequestProxy);
            return enhancer.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (ClassUtil.isBaseMethod(method)) {
            return methodProxy.invokeSuper(o, objects);
        }

        return null;
    }

}
