package org.hystudio.httpframework.framework.proxy;


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;


public class HttpRequestProxyFactory {
    public static Object createProxy(BeanDefinition beanDefinition) {
        try {
            Callback[] callbacks = new Callback[2];
            callbacks[1] = new HttpRequestProxyInterceptor();
            callbacks[0] = new HttpRequestProxyDefaultInterceptor();
            Class clazz = Class.forName(beanDefinition.getBeanClassName());
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(clazz);
            enhancer.setCallbacks(callbacks);
            enhancer.setCallbackFilter(new HttpRequestProxyFilter());
            Object result = enhancer.create();
            //System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
