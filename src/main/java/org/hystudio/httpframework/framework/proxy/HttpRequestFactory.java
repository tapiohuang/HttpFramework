package org.hystudio.httpframework.framework.proxy;


import org.hystudio.httpframework.framework.*;
import org.hystudio.httpframework.framework.annotation.Request;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;


/**
 * 1.创建HttpRequest的代理对象，使用Cglib创建
 * 2.为所有的方法创建HttpSessionDefinition
 * 3.将HttpSessionDefinition注册
 */
public class HttpRequestFactory {
    private final Callback[] callbacks;
    private final HttpRequestProxyFilter httpRequestProxyFilter;
    private HttpSessionDefinitionRegistry httpSessionDefinitionRegistry;
    private ApplicationContext applicationContext;
    private HttpSessionThreadPool httpSessionThreadPool;
    private HttpSessionFactory httpSessionFactory;

    public HttpRequestFactory(HttpSessionDefinitionRegistry httpSessionDefinitionRegistry, ApplicationContext applicationContext) {
        this.httpSessionDefinitionRegistry = httpSessionDefinitionRegistry;
        this.applicationContext = applicationContext;
        this.httpSessionThreadPool = new HttpSessionThreadPool();
        this.httpSessionFactory = new HttpSessionFactory(httpSessionDefinitionRegistry);
        callbacks = new Callback[2];
        callbacks[1] = new HttpSessionHandle(httpSessionThreadPool, httpSessionFactory);
        callbacks[0] = new DefaultHttpRequestInterceptor();
        httpRequestProxyFilter = new HttpRequestProxyFilter();
    }

    /**
     * 1.创建代理对象
     *
     * @param beanDefinition BeanDefinition
     * @return Object
     */
    public Object createProxy(BeanDefinition beanDefinition) {
        try {
            Class clazz = Class.forName(beanDefinition.getBeanClassName());
            this.buildHttpSessionDefinition(clazz);
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(clazz);
            enhancer.setCallbacks(callbacks);
            enhancer.setCallbackFilter(httpRequestProxyFilter);
            return enhancer.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void buildHttpSessionDefinition(Class clazz) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods
        ) {
            if (method.isAnnotationPresent(Request.class)) {
                createHttpSessionDefinition(method);
            }
        }
    }

    private void createHttpSessionDefinition(Method method) {
        HttpSessionDefinition httpSessionDefinition = new HttpSessionDefinition(
                method,
                method.getParameterTypes(),
                method.getParameterTypes().length,
                method.getParameterAnnotations()
        );
        httpSessionDefinitionRegistry.addDefinition(httpSessionDefinition);
    }

}
