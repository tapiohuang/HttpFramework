package org.hystudio.httpframework.framework.proxy;

import org.hystudio.httpframework.framework.handle.RequestHandle;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HttpRequestProxyInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        RequestHandle requestHandle = new RequestHandle(method, objects);
        return requestHandle.handle();
    }
}
