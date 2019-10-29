package org.hystudio.httpframework;

import org.hystudio.httpframework.annoations.Request;
import org.hystudio.httpframework.beans.MethodParametersBean;
import org.hystudio.httpframework.beans.RequestEntityObjectBean;
import org.hystudio.httpframework.httpdatas.RequestData;
import org.hystudio.httpframework.resolvers.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class RequestSessionFactory implements
        IMethodParameterResolver, IRequestDataResolver, IRequestSession {
    private final Method method;
    private final Object[] objects;
    private final Request request;
    private final MethodParameterResolver methodParameterResolver = new MethodParameterResolver();
    private final ResponseDataResolver responseDataResolver = new ResponseDataResolver();
    private final RequestDataResolver requestDataResolver = new RequestDataResolver();
    private final RequestSession requestSession = RequestSession.createSession();
    private final MethodParametersBean methodParametersBean = new MethodParametersBean();

    private RequestSessionFactory(Method method, Object[] objects) {
        this.method = method;
        this.objects = objects;
        this.request = method.getAnnotation(Request.class);
    }

    static RequestSessionFactory createFactory(Method method, Object[] objects) {
        return new RequestSessionFactory(method, objects);
    }

    RequestSession createRequestSession() {
        this.preInitResolver();
        this.initResolver();
        this.initRequestSession();
        return requestSession;
    }

    private void preInitResolver() {
        this.setObjects(this.objects);
        this.setMethodParameterAnnotations(method.getParameterAnnotations());
        this.setMethodParametersBean(this.methodParametersBean);
        this.methodParameterResolver.resolver();

    }

    private void initResolver() {
        this.setRequestData(this.requestSession.getRequestData());
        this.setRequestEntityObjectList(this.methodParametersBean.getRequestEntityObjectList());
        this.setRequestEntityObjectBean(this.methodParametersBean.getRequestEntityObjectBean());
        this.setRequestHeaderObjectList(this.methodParametersBean.getRequestHeaderObjectList());
        this.requestDataResolver.setProcessorList(this.methodParametersBean.getRequestProcessorList());
    }

    private void initRequestSession() {
        this.setRequestDataResolver(this.requestDataResolver);
        this.setResponseDataResolver(this.responseDataResolver);
        this.setContentType(this.request.contentType());
        this.setDataType(this.request.dataType());
        this.setUrl(this.request.url());
        this.setRequestMethod(this.request.method());
    }

    @Override
    public void setObjects(Object[] objects) {
        this.methodParameterResolver.setObjects(objects);
    }

    @Override
    public void setMethodParameterAnnotations(Annotation[][] parameterAnnotations) {
        this.methodParameterResolver.setMethodParameterAnnotations(parameterAnnotations);
    }

    @Override
    public void setMethodParametersBean(MethodParametersBean methodParametersBean) {
        this.methodParameterResolver.setMethodParametersBean(methodParametersBean);
    }

    @Override
    public void setRequestData(RequestData requestData) {
        this.requestDataResolver.setRequestData(requestData);
    }

    @Override
    public void setRequestEntityObjectList(LinkedList<Object> requestEntityObjectList) {
        this.requestDataResolver.setRequestEntityObjectList(requestEntityObjectList);
    }

    @Override
    public void setRequestHeaderObjectList(LinkedList<Object> requestHeaderObjectList) {
        this.requestDataResolver.setRequestHeaderObjectList(requestHeaderObjectList);
    }

    @Override
    public void setRequestEntityObjectBean(RequestEntityObjectBean requestEntityObjectBean) {
        this.requestDataResolver.setRequestEntityObjectBean(requestEntityObjectBean);
    }

    @Override
    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestSession.setRequestMethod(requestMethod);
    }

    @Override
    public void setUrl(String url) {
        this.requestSession.setUrl(url);
    }

    @Override
    public void setContentType(ContentType contentType) {
        this.requestSession.setContentType(contentType);
    }

    @Override
    public void setDataType(DataType dataType) {
        this.requestSession.setDataType(dataType);
    }

    @Override
    public void setResponseDataResolver(ResponseDataResolver responseDataResolver) {
        this.requestSession.setResponseDataResolver(responseDataResolver);
    }

    @Override
    public void setRequestDataResolver(RequestDataResolver requestDataResolver) {
        this.requestSession.setRequestDataResolver(requestDataResolver);
    }

    @Override
    public void setHttpResolver(HttpResolver httpResolver) {
        this.requestSession.setHttpResolver(httpResolver);
    }

}
