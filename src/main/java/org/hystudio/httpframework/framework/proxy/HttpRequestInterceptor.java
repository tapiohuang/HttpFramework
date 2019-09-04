package org.hystudio.httpframework.framework.proxy;

import org.hystudio.httpframework.framework.HttpSessionTemplate;
import org.hystudio.httpframework.framework.handle.RequestHandle;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashMap;

public class HttpRequestInterceptor /*extends RequestHandle*/ implements MethodInterceptor {

    private HttpSessionTemplateMap httpSessionTemplateMap = HttpSessionTemplateMap.getInstance();

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        HttpSessionTemplate httpSessionTemplate = httpSessionTemplateMap.getHttpSessionTemplate(method.getName());
        System.out.println(httpSessionTemplate);
        RequestHandle requestHandle = new RequestHandle();
        return requestHandle.handle(method, objects);
    }
}
