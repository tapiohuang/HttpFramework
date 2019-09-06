package org.hystudio.httpframework.framework;

import com.sun.xml.internal.ws.api.pipe.ContentType;
import org.hystudio.httpframework.framework.annotation.HttpRequest;
import org.hystudio.httpframework.framework.annotation.Request;
import org.hystudio.httpframework.framework.config.RequestContentType;
import org.hystudio.httpframework.framework.config.RequestMethod;
import org.hystudio.httpframework.framework.config.ResponseDataType;
import org.hystudio.httpframework.framework.handle.RequestHandle;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class HttpSessionDefinition {
    private final Method method;
    private final Class[] argsType;
    private final int argNumb;
    private final Annotation[][] argsAnnotations;
    private RequestMethod requestMethod;
    private String requestUrl;
    private Request request;
    private RequestContentType requestContentType;
    private ResponseDataType responseDataType;
    private int requestTimeout;

    public HttpSessionDefinition(Method method, Class[] argsType, int argNumb, Annotation[][] argsAnnotations) {
        this.method = method;
        this.argsType = argsType;
        this.argNumb = argNumb;
        this.argsAnnotations = argsAnnotations;
        this.initDefinition();
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public RequestContentType getRequestContentType() {
        return requestContentType;
    }

    public void setRequestContentType(RequestContentType requestContentType) {
        this.requestContentType = requestContentType;
    }

    public ResponseDataType getResponseDataType() {
        return responseDataType;
    }

    public void setResponseDataType(ResponseDataType responseDataType) {
        this.responseDataType = responseDataType;
    }

    public int getRequestTimeout() {
        return requestTimeout;
    }

    public void setRequestTimeout(int requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    private void initDefinition() {
        request = this.method.getAnnotation(Request.class);
        this.readRequestMethod();
        this.readRequestUrl();
        this.readRequestContentType();
        this.readResponseDataType();
        this.readRequestTimeout();
    }

    private void readRequestMethod() {
        this.requestMethod = request.method();
    }

    private void readRequestUrl() {
        this.requestUrl = request.url();
    }

    private void readRequestContentType() {
        this.requestContentType = request.contentType();
    }

    private void readResponseDataType() {
        this.responseDataType = request.dataType();
    }

    private void readRequestTimeout() {
        this.requestTimeout = request.timeout();
    }

    public Method getMethod() {
        return method;
    }

    public Class[] getArgsType() {
        return argsType;
    }

    public int getArgNumb() {
        return argNumb;
    }

    public Annotation[][] getArgsAnnotations() {
        return argsAnnotations;
    }

    @Override
    public String toString() {
        return "HttpSessionDefinition{" +
                "method=" + method +
                ", argsType=" + Arrays.toString(argsType) +
                ", argNumb=" + argNumb +
                ", argsAnnotations=" + Arrays.toString(argsAnnotations) +
                '}';
    }
}
