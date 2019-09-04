package org.hystudio.httpframework.framework.proxy;


import org.hystudio.httpframework.framework.HttpSessionTemplate;
import org.hystudio.httpframework.framework.annotation.Request;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Method;
import java.util.HashMap;


public class HttpRequestFactory {
    private static HttpRequestFactory ourHttpRequestFactory = new HttpRequestFactory();
    private final Callback[] callbacks;
    private final HttpRequestProxyFilter httpRequestProxyFilter;
    private HttpSessionTemplateMap httpSessionTemplateMap;

    private HttpRequestFactory() {
        httpSessionTemplateMap = HttpSessionTemplateMap.getInstance();
        callbacks = new Callback[2];
        callbacks[1] = new HttpRequestProxyInterceptor();
        callbacks[0] = new HttpRequestProxyDefaultInterceptor();
        httpRequestProxyFilter = new HttpRequestProxyFilter();
    }

    public static HttpRequestFactory getInstance() {
        return ourHttpRequestFactory;
    }

    public Object createProxy(BeanDefinition beanDefinition) {
        try {
            Class clazz = Class.forName(beanDefinition.getBeanClassName());
            buildHttpSessionTemplate(clazz);
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(clazz);
            enhancer.setCallbacks(callbacks);
            enhancer.setCallbackFilter(httpRequestProxyFilter);
            Object result = enhancer.create();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void buildHttpSessionTemplate(Class clazz) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods
        ) {
            if (method.isAnnotationPresent(Request.class)) {
                createHttpSessionTemplate(method);
            }
        }
    }

    private void createHttpSessionTemplate(Method method) {
        String httpSessionTemplateName = String.valueOf(method.getName());
        HttpSessionTemplate httpSessionTemplate = new HttpSessionTemplate(
                method,
                method.getParameterTypes(),
                method.getParameterTypes().length,
                method.getParameterAnnotations()
        );
        httpSessionTemplateMap.addHttpSessionTemplate(httpSessionTemplateName, httpSessionTemplate);
    }
}
