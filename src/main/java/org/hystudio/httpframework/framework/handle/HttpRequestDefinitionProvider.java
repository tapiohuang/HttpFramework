package org.hystudio.httpframework.framework.handle;


import org.hystudio.httpframework.framework.annotation.*;
import org.hystudio.httpframework.framework.data.HttpRequestDefinition;
import org.hystudio.httpframework.framework.data.request.RequestData;
import org.hystudio.httpframework.framework.data.request.RequestEntities;
import org.hystudio.httpframework.framework.data.request.RequestHeaders;
import org.hystudio.httpframework.framework.data.response.ResponseData;
import org.hystudio.httpframework.framework.exception.HttpRequestException;
import org.hystudio.httpframework.framework.interfaces.ContentParser;
import org.hystudio.httpframework.framework.interfaces.DataParser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class HttpRequestDefinitionProvider {

    private Method method;
    private Object[] args;
    private HttpRequestDefinition httpRequestDefinition;
    private Request requestAnnotation;


    public HttpRequestDefinition provide(Method method, Object[] args) {
        this.method = method;
        this.args = args;
        this.httpRequestDefinition = new HttpRequestDefinition();
        this.readRequestAnnotation();//1.获取方法上的注解
        this.readRequestUrl();//2.设置请求的URL
        this.readArgs();//3.获取方法中的参数
        this.setResponseType();//4.设置方法的返回类型
        this.setRequestMethod();//5.设置请求类型
        this.setRequestContentType();//6.设置请求数据类型
        this.setResponseDataType();//8.设置返回数据类型
        this.setCurrentThread();//9.设置当前对应的线程
        this.setRequestData();//10.设置请求的数据
        this.setResponseData();//11.设置返回的数据
        this.setTimeout();//12.设置超时时间
        return this.httpRequestDefinition;
    }

    private void readRequestAnnotation() {
        this.requestAnnotation = this.method.getAnnotation(Request.class);
        if (this.requestAnnotation == null) {
            throw new HttpRequestException("无法解析方法:" + method.toString());
        }
    }

    private void readRequestUrl() {
        httpRequestDefinition.setRequestUrl(this.requestAnnotation.url());
    }

    private void readArgs() {
        RequestEntities requestEntities = new RequestEntities();
        RequestHeaders requestHeaders = new RequestHeaders();
        ContentParser contentParser = null;
        DataParser dataParser = null;
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (int j = 0; j < parameterAnnotations[i].length; j++) {
                if (parameterAnnotations[i][j] instanceof RequestEntity) {
                    requestEntities.addEntity(args[i]);
                }
                if (parameterAnnotations[i][j] instanceof RequestHeader) {
                    requestHeaders.addHeader(args[i]);
                }
                if (parameterAnnotations[i][j] instanceof RequestParser) {
                    if (args[i].getClass().isInstance(ContentParser.class)) {
                        contentParser = (ContentParser) args[i];
                    }
                }
                if (parameterAnnotations[i][j] instanceof ResponseParser) {
                    if (args[i].getClass().isInstance(DataParser.class)) {
                        dataParser = (DataParser) args[i];
                    }
                }
            }
        }
        httpRequestDefinition.setRequestEntities(requestEntities);
        httpRequestDefinition.setRequestHeaders(requestHeaders);
        httpRequestDefinition.setContentParser(contentParser);
        httpRequestDefinition.setDataParser(dataParser);
    }

    private void setResponseType() {
        httpRequestDefinition.setResponseType(method.getReturnType());
    }

    private void setRequestMethod() {
        httpRequestDefinition.setRequestMethod(requestAnnotation.method());
    }


    private void setRequestContentType() {
        httpRequestDefinition.setRequestContentType(requestAnnotation.contentType());
    }

    private void setResponseDataType() {
        httpRequestDefinition.setResponseDataType(requestAnnotation.dataType());
    }

    private void setCurrentThread() {
        httpRequestDefinition.setCurrentThread(Thread.currentThread());
    }

    private void setRequestData() {
        httpRequestDefinition.setRequestData(new RequestData());
    }

    private void setResponseData() {
        httpRequestDefinition.setResponseData(new ResponseData());
    }

    private void setTimeout() {
        httpRequestDefinition.setTimeout(this.requestAnnotation.timeout());
    }
}
