package org.hystudio.httpframework.framework.data;

import org.hystudio.httpframework.framework.config.RequestContentType;
import org.hystudio.httpframework.framework.config.RequestMethod;
import org.hystudio.httpframework.framework.config.ResponseDataType;
import org.hystudio.httpframework.framework.data.request.RequestData;
import org.hystudio.httpframework.framework.data.request.RequestEntities;
import org.hystudio.httpframework.framework.data.request.RequestHeaders;
import org.hystudio.httpframework.framework.data.response.ResponseData;
import org.hystudio.httpframework.framework.interfaces.ContentParser;
import org.hystudio.httpframework.framework.interfaces.DataParser;

import java.net.HttpURLConnection;
import java.net.Proxy;


public class HttpRequestDefinition {
    private ResponseDataType responseDataType;
    private RequestContentType requestContentType;
    private RequestMethod requestMethod;
    private String requestUrl;
    private ContentParser contentParser;
    private DataParser dataParser;
    private Class responseType;
    private RequestEntities requestEntities;
    private RequestHeaders requestHeaders;
    private Thread currentThread;
    private RequestData requestData;
    private ResponseData responseData;
    private HttpURLConnection httpURLConnection;
    private Integer timeout;
    private HttpProxy httpProxy;

    @Override
    public String toString() {
        return "HttpRequestDefinition{" +
                "responseDataType=" + responseDataType +
                ", requestContentType=" + requestContentType +
                ", requestMethod=" + requestMethod +
                ", requestUrl='" + requestUrl + '\'' +
                ", contentParser=" + contentParser +
                ", dataParser=" + dataParser +
                ", responseType=" + responseType +
                ", requestEntities=" + requestEntities +
                ", requestHeaders=" + requestHeaders +
                ", currentThread=" + currentThread +
                ", requestData=" + requestData +
                ", responseData=" + responseData +
                ", httpURLConnection=" + httpURLConnection +
                ", timeout=" + timeout +
                ", httpProxy=" + httpProxy +
                '}';
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public HttpURLConnection getHttpURLConnection() {
        return httpURLConnection;
    }

    public void setHttpURLConnection(HttpURLConnection httpURLConnection) {
        this.httpURLConnection = httpURLConnection;
    }
    //private RequestClient requestClient;

    public ResponseDataType getResponseDataType() {
        return responseDataType;
    }

    public void setResponseDataType(ResponseDataType responseDataType) {
        this.responseDataType = responseDataType;
    }

    public RequestContentType getRequestContentType() {
        return requestContentType;
    }

    public void setRequestContentType(RequestContentType requestContentType) {
        this.requestContentType = requestContentType;
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

    public ContentParser getContentParser() {
        return contentParser;
    }

    public void setContentParser(ContentParser contentParser) {
        this.contentParser = contentParser;
    }

    public DataParser getDataParser() {
        return dataParser;
    }

    public void setDataParser(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    public Class getResponseType() {
        return responseType;
    }

    public void setResponseType(Class responseType) {
        this.responseType = responseType;
    }

    public RequestEntities getRequestEntities() {
        return requestEntities;
    }

    public void setRequestEntities(RequestEntities requestEntities) {
        this.requestEntities = requestEntities;
    }

    public RequestHeaders getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(RequestHeaders requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public Thread getCurrentThread() {
        return currentThread;
    }

    public void setCurrentThread(Thread currentThread) {
        this.currentThread = currentThread;
    }

    public RequestData getRequestData() {
        return requestData;
    }

    public void setRequestData(RequestData requestData) {
        this.requestData = requestData;
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }


    public HttpProxy getHttpProxy() {
        return httpProxy;
    }

    public void setHttpProxy(HttpProxy httpProxy) {
        this.httpProxy = httpProxy;
    }
}
