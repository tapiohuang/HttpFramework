package org.hystudio.httpframework;

import org.hystudio.httpframework.utils.ClassUtil;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HttpRequestProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (ClassUtil.isBaseMethod(method)) {
            return methodProxy.invokeSuper(o, objects);
        }
        RequestSessionFactory requestSessionFactory = RequestSessionFactory.createFactory(method, objects);
        RequestSession requestSession = requestSessionFactory.createRequestSession();
        Object result = RequestSessionExecutor.execute(requestSession);
        return null;
    }
}
