package org.hystudio.httpframework.framework2.registry;


import org.hystudio.httpframework.framework2.annotation.*;
import org.hystudio.httpframework.framework2.session.HttpSessionDefinition;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/**
 * HttpSessionDefinition的扫描器，在整个生命周期是单例的
 */
public class HttpSessionDefinitionRegistry {
    private final HashMap<Method, HttpSessionDefinition> HttpSessionDefinitionMap = new HashMap<>();

    public void registerHttpSessionDefinition(String beanName) throws ClassNotFoundException {
        Class clazz = Class.forName(beanName);
        Method[] methods = clazz.getMethods();
        for (Method m : methods
        ) {
            parser(m);
        }
    }

    private void parser(Method method) {
        Request request = method.getAnnotation(Request.class);
        if (request == null) {
            return;
        }
        Annotation[][] methodParameterAnnotations = method.getParameterAnnotations();
        int[] requestProcessorOrder = new int[methodParameterAnnotations.length];
        int[] responseProcessorOrder = new int[methodParameterAnnotations.length];
        int[] requestEntityIndexes = new int[methodParameterAnnotations.length];
        int[] requestHeaderIndexes = new int[methodParameterAnnotations.length];
        int requestProcessorOrderIndex = 0;
        int responseProcessorOrderIndex = 0;
        int requestEntityIndex = 0;
        int requestHeaderIndex = 0;
        int proxyIndex = -1;
        for (int i = 0; i < methodParameterAnnotations.length; i++) {
            Annotation annotation = methodParameterAnnotations[i][0];
            if (annotation.annotationType().equals(RequestEntity.class)) {
                requestEntityIndexes[requestEntityIndex] = i;
                requestEntityIndex++;
            }
            if (annotation.annotationType().equals(RequestProcessor.class)) {
                requestProcessorOrder[requestProcessorOrderIndex] = i;
                requestProcessorOrderIndex++;
            }
            if (annotation.annotationType().equals(ResponseProcessor.class)) {
                responseProcessorOrder[responseProcessorOrderIndex] = i;
                responseProcessorOrderIndex++;
            }
            if (annotation.annotationType().equals(RequestHeader.class)) {
                requestHeaderIndexes[requestHeaderIndex] = i;
                requestHeaderIndex++;
            }
            if (annotation.annotationType().equals(Proxy.class)) {
                proxyIndex = i;
            }
        }
        HttpSessionDefinition httpSessionDefinition = new HttpSessionDefinition();
        httpSessionDefinition.setRequestEntityIndexes(Arrays.copyOfRange(requestEntityIndexes, 0, requestEntityIndex));
        httpSessionDefinition.setRequestHeaderIndexes(Arrays.copyOfRange(requestHeaderIndexes, 0, requestHeaderIndex));
        httpSessionDefinition.setRequestProcessorOrder(Arrays.copyOfRange(requestProcessorOrder, 0, requestProcessorOrderIndex));
        httpSessionDefinition.setResponseProcessorOrder(Arrays.copyOfRange(responseProcessorOrder, 0, responseProcessorOrderIndex));

        httpSessionDefinition.setContentType(request.contentType());
        httpSessionDefinition.setDataType(request.dataType());
        httpSessionDefinition.setRequestMethod(request.method());
        httpSessionDefinition.setTimeout(request.timeout());
        httpSessionDefinition.setProxyIndex(proxyIndex);
        httpSessionDefinition.setUrl(request.url());
        httpSessionDefinition.setMethod(method);

        HttpSessionDefinitionMap.put(method, httpSessionDefinition);
    }

    public HttpSessionDefinition getHttpSessionDefinition(Method method) {
        return HttpSessionDefinitionMap.get(method);
    }

    @Override
    public String toString() {
        return "HttpSessionDefinitionRegistry{" +
                "HttpSessionDefinitionMap=" + HttpSessionDefinitionMap +
                '}';
    }
}
