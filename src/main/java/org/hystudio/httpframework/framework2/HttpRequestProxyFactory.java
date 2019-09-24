package org.hystudio.httpframework.framework2;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;

final class HttpRequestProxyFactory {
    private ApplicationContext applicationContext;

    HttpRequestProxyFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    Object createProxy(BeanDefinition beanDefinition) {
        try {
            Class clazz = Class.forName(beanDefinition.getBeanClassName());
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(clazz);
            enhancer.setCallback(new HttpRequestProxyMethodInterceptor(this.applicationContext));
            return enhancer.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
