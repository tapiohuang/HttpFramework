package org.hystudio.httpframework;

import org.hystudio.httpframework.farmework.MethodParameterBean;
import org.hystudio.httpframework.farmework.MethodParameterPackage;
import org.hystudio.httpframework.farmework.RequestData;
import org.hystudio.httpframework.type.HTTPContentType;
import org.hystudio.httpframework.type.HTTPDataType;
import org.hystudio.httpframework.type.HTTPRequestMethodType;

import java.lang.reflect.Method;

public class HTTPSession {
    private final Object[] objects;
    private final Method method;
    private Object resultObject;
    private MethodParameterBean methodParameterBean;
    private MethodParameterPackage methodParameterPackage;
    private RequestData requestData;
    private HTTPRequestMethodType httpRequestMethodType;
    private HTTPDataType httpDataType;
    private HTTPContentType httpContentType;
    private String url;

    public HTTPSession(Object[] objects, Method method) {
        this.objects = objects;
        this.method = method;
    }

    public HTTPRequestMethodType getHttpRequestMethodType() {
        return httpRequestMethodType;
    }

    public void setHttpRequestMethodType(HTTPRequestMethodType httpRequestMethodType) {
        this.httpRequestMethodType = httpRequestMethodType;
    }

    public HTTPDataType getHttpDataType() {
        return httpDataType;
    }

    public void setHttpDataType(HTTPDataType httpDataType) {
        this.httpDataType = httpDataType;
    }

    public HTTPContentType getHttpContentType() {
        return httpContentType;
    }

    public void setHttpContentType(HTTPContentType httpContentType) {
        this.httpContentType = httpContentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getResultObject() {
        return resultObject;
    }

    public Object[] getObjects() {
        return objects;
    }

    public Method getMethod() {
        return method;
    }

    public MethodParameterBean getMethodParameterBean() {
        return methodParameterBean;
    }

    public void setMethodParameterBean(MethodParameterBean methodParameterBean) {
        this.methodParameterBean = methodParameterBean;
    }

    public MethodParameterPackage getMethodParameterPackage() {
        return methodParameterPackage;
    }

    public void setMethodParameterPackage(MethodParameterPackage methodParameterPackage) {
        this.methodParameterPackage = methodParameterPackage;
    }

    public RequestData getRequestData() {
        return requestData;
    }

    public void setRequestData(RequestData requestData) {
        this.requestData = requestData;
    }
}
