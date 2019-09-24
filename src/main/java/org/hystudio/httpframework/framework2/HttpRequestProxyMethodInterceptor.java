package org.hystudio.httpframework.framework2;

import org.hystudio.httpframework.framework2.executor.HttpSessionExecutor;
import org.hystudio.httpframework.framework2.executor.HttpSessionExecutorThreadPool;
import org.hystudio.httpframework.framework2.session.*;
import org.hystudio.httpframework.utils.ClassUtil;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;

class HttpRequestProxyMethodInterceptor implements MethodInterceptor {
    private ApplicationContext applicationContext;
    private HttpSessionFactory httpSessionFactory;
    private HttpSessionDefinitionRegistry httpSessionDefinitionRegistry;
    private HttpSessionExecutorThreadPool httpSessionExecutorThreadPool;

    HttpRequestProxyMethodInterceptor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.httpSessionFactory = applicationContext.getBean(HttpSessionFactory.class);
        this.httpSessionDefinitionRegistry = applicationContext.getBean(HttpSessionDefinitionRegistry.class);
        this.httpSessionExecutorThreadPool = applicationContext.getBean(HttpSessionExecutorThreadPool.class);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (ClassUtil.isBaseMethod(method)) {
            return methodProxy.invokeSuper(o, objects);
        }
        HttpSessionDefinition httpSessionDefinition = httpSessionDefinitionRegistry.getHttpSessionDefinition(method);
        HttpSession httpSession = httpSessionFactory.createHttpSession(httpSessionDefinition, objects);
        HttpSessionExecutor httpSessionExecutor = new HttpSessionExecutor(httpSession);
        this.httpSessionExecutorThreadPool.addHttpSessionExecutor(httpSessionExecutor);
        return null;
    }
}
