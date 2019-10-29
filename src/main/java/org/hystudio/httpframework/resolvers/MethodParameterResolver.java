package org.hystudio.httpframework.resolvers;


import org.hystudio.httpframework.annoations.*;
import org.hystudio.httpframework.beans.MethodParametersBean;
import org.hystudio.httpframework.beans.RequestEntityObjectBean;
import org.hystudio.httpframework.exceptions.RequestPrepareResolverException;
import org.hystudio.httpframework.processors.IProcessor;
import org.hystudio.httpframework.processors.IRequestProcessor;
import org.hystudio.httpframework.utils.ClassUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class MethodParameterResolver implements IResolver, IMethodParameterResolver {
    private MethodParametersBean methodParametersBean;
    private Object[] objects;
    private Annotation[][] parameterAnnotations;

    public MethodParametersBean getMethodParametersBean() {
        return methodParametersBean;
    }

    @Override
    public void setMethodParametersBean(MethodParametersBean methodParametersBean) {
        this.methodParametersBean = methodParametersBean;
    }

    @Override
    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    @Override
    public void setMethodParameterAnnotations(Annotation[][] parameterAnnotations) {
        this.parameterAnnotations = parameterAnnotations;
    }

    @Override
    public void resolver() {
        LinkedList<Object> requestEntityObjectList = this.methodParametersBean.getRequestEntityObjectList();
        LinkedList<Object> requestHeaderObjectList = this.methodParametersBean.getRequestHeaderObjectList();
        LinkedList<IRequestProcessor> requestProcessorList = this.methodParametersBean.getRequestProcessorList();
        LinkedList<IProcessor> responseProcessorList = this.methodParametersBean.getResponseProcessorList();
        LinkedList<Object> requestProxyList = this.methodParametersBean.getRequestProxyList();
        if (parameterAnnotations == null) {
            throw new RequestPrepareResolverException("ParameterAnnotations is null!");
        }
        for (int i = 0; i < parameterAnnotations.length; i++) {
            Annotation annotation = parameterAnnotations[i][0];
            if (annotation.annotationType().equals(RequestEntity.class)) {
                requestEntityObjectList.add(objects[i]);
            }
            if (annotation.annotationType().equals(RequestProcessor.class)) {
                requestProcessorList.add((IRequestProcessor) objects[i]);
            }
            if (annotation.annotationType().equals(ResponseProcessor.class)) {
                responseProcessorList.add((IProcessor) objects[i]);
            }
            if (annotation.annotationType().equals(RequestHeader.class)) {
                requestHeaderObjectList.add(objects[i]);
            }
            if (annotation.annotationType().equals(RequestProxy.class)) {
                requestProxyList.add(objects[i]);
            }
        }
        this.createRequestEntityObjectBean();
    }

    private void createRequestEntityObjectBean() {
        RequestEntityObjectBean requestEntityObjectBean = this.methodParametersBean.getRequestEntityObjectBean();
        for (Object o : this.methodParametersBean.getRequestEntityObjectList()
        ) {
            Method[] methods = o.getClass().getMethods();
            for (Method m : methods
            ) {
                if (!ClassUtil.isBaseMethod(m)) {
                    requestEntityObjectBean.addMethod(m, o);
                }
            }
        }
    }
}
