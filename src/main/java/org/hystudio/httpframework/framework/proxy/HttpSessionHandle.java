package org.hystudio.httpframework.framework.proxy;

import org.hystudio.httpframework.framework.*;
import org.hystudio.httpframework.framework.handle.RequestHandle;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HttpSessionHandle implements MethodInterceptor {
    private HttpSessionThreadPool httpSessionThreadPool;

    private HttpSessionFactory httpSessionFactory;

    public HttpSessionHandle(HttpSessionThreadPool httpSessionThreadPool, HttpSessionFactory httpSessionFactory) {
        this.httpSessionFactory = httpSessionFactory;
        this.httpSessionThreadPool = httpSessionThreadPool;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        HttpSession httpSession = httpSessionFactory.createHttpSession(method, objects);
        httpSessionThreadPool.addSessionExecutor(httpSession);
        return httpSession.readResult();
    }
}
