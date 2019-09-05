package org.hystudio.httpframework.framework.proxy;

import org.hystudio.httpframework.framework.*;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;

public class HttpSessionHandle implements MethodInterceptor {
    private HttpSessionThreadPool httpSessionThreadPool;
    private ApplicationContext applicationContext;
    private HttpSessionFactory httpSessionFactory;
    private boolean inited = false;

    public HttpSessionHandle(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    private synchronized void init() {
        if (httpSessionThreadPool == null) {
            httpSessionThreadPool = applicationContext.getBean(HttpSessionThreadPool.class);
        }
        if (httpSessionFactory == null) {
            httpSessionFactory = applicationContext.getBean(HttpSessionFactory.class);
        }
        if (httpSessionThreadPool == null) {
            throw new RuntimeException("httpSessionThreadPool is null");
        }
        if (httpSessionFactory == null) {
            throw new RuntimeException("httpSessionFactory is null");
        }
        inited = true;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (!inited) {
            init();
        }
        HttpSession httpSession = httpSessionFactory.createHttpSession(method, objects);
        httpSessionThreadPool.addSessionExecutor(httpSession);
        return httpSession.readResult();
    }
}
