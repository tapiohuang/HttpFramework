package org.hystudio.httpframework.framework2.session;

import org.hystudio.httpframework.framework2.config.ContentType;
import org.hystudio.httpframework.framework2.config.DataType;
import org.hystudio.httpframework.framework2.config.RequestMethod;

import java.lang.reflect.Method;
import java.util.Arrays;

public class HttpSessionDefinition {
    private Method method;
    private int[] requestProcessorOrder;
    private int[] responseProcessorOrder;
    private int[] requestEntityIndexes;
    private int[] requestHeaderIndexes;
    private int[] requestParameterIndexes;
    private int proxyIndex;
    private int timeout;
    private ContentType contentType;
    private DataType dataType;
    private RequestMethod requestMethod;
    private String url;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public int[] getRequestProcessorOrder() {
        return requestProcessorOrder;
    }

    public void setRequestProcessorOrder(int[] requestProcessorOrder) {
        this.requestProcessorOrder = requestProcessorOrder;
    }

    public int[] getResponseProcessorOrder() {
        return responseProcessorOrder;
    }

    public void setResponseProcessorOrder(int[] responseProcessorOrder) {
        this.responseProcessorOrder = responseProcessorOrder;
    }

    public int[] getRequestEntityIndexes() {
        return requestEntityIndexes;
    }

    public void setRequestEntityIndexes(int[] requestEntityIndexes) {
        this.requestEntityIndexes = requestEntityIndexes;
    }

    public int getProxyIndex() {
        return proxyIndex;
    }

    public void setProxyIndex(int proxyIndex) {
        this.proxyIndex = proxyIndex;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int[] getRequestHeaderIndexes() {
        return requestHeaderIndexes;
    }

    public void setRequestHeaderIndexes(int[] requestHeaderIndexes) {
        this.requestHeaderIndexes = requestHeaderIndexes;
    }

    public int[] getRequestParameterIndexes() {
        return requestParameterIndexes;
    }

    public void setRequestParameterIndexes(int[] requestParameterIndexes) {
        this.requestParameterIndexes = requestParameterIndexes;
    }

    @Override
    public String toString() {
        return "HttpSessionDefinition{" +
                "method=" + method +
                ", requestProcessorOrder=" + Arrays.toString(requestProcessorOrder) +
                ", responseProcessorOrder=" + Arrays.toString(responseProcessorOrder) +
                ", requestEntityIndexes=" + Arrays.toString(requestEntityIndexes) +
                ", requestHeaderIndexes=" + Arrays.toString(requestHeaderIndexes) +
                ", requestParameterIndexes=" + Arrays.toString(requestParameterIndexes) +
                ", proxyIndex=" + proxyIndex +
                ", timeout=" + timeout +
                ", contentType=" + contentType +
                ", dataType=" + dataType +
                ", requestMethod=" + requestMethod +
                ", url='" + url + '\'' +
                '}';
    }
}
