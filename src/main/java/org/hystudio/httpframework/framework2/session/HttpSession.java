package org.hystudio.httpframework.framework2.session;

import org.hystudio.httpframework.framework2.config.RequestMethod;
import org.hystudio.httpframework.framework2.data.RequestData;
import org.hystudio.httpframework.framework2.data.ResponseData;
import org.hystudio.httpframework.framework2.processors2.RequestProcessorsHandle;
import org.hystudio.httpframework.framework2.processors2.ResponseProcessorsHandle;
import org.hystudio.httpframework.framework2.sender.ISender;
import org.hystudio.httpframework.framework2.reader.IReader;

public class HttpSession {
    private ISender sender;//请求的发送器
    private IReader reader;//请求的接收器
    private RequestMethod requestMethod;//请求方式
    private RequestData requestData;//请求数据
    private ResponseData responseData;//返回数据
    private HttpSessionConnection httpSessionConnection;//会话的Http连接
    private RequestProcessorsHandle requestProcessorHandle;
    private ResponseProcessorsHandle responseProcessorHandle;
    private String url;
    private Object result;

    HttpSession() {
    }

    public Object getResult() {
        return result;
    }

    public ISender getSender() {
        return sender;
    }

    public void setSender(ISender sender) {
        this.sender = sender;
    }

    public IReader getReader() {
        return reader;
    }

    public void setReader(IReader reader) {
        this.reader = reader;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
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

    public HttpSessionConnection getHttpSessionConnection() {
        return httpSessionConnection;
    }

    public void setHttpSessionConnection(HttpSessionConnection httpSessionConnection) {
        this.httpSessionConnection = httpSessionConnection;
    }

    public RequestProcessorsHandle getRequestProcessorHandle() {
        return requestProcessorHandle;
    }

    public void setRequestProcessorHandle(RequestProcessorsHandle requestProcessorHandle) {
        this.requestProcessorHandle = requestProcessorHandle;
    }

    public ResponseProcessorsHandle getResponseProcessorHandle() {
        return responseProcessorHandle;
    }

    public void setResponseProcessorHandle(ResponseProcessorsHandle responseProcessorHandle) {
        this.responseProcessorHandle = responseProcessorHandle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "HttpSession{" +
                "sender=" + sender +
                ", reader=" + reader +
                ", requestMethod=" + requestMethod +
                ", requestData=" + requestData +
                ", responseData=" + responseData +
                ", httpSessionConnection=" + httpSessionConnection +
                ", requestProcessorHandle=" + requestProcessorHandle +
                ", responseProcessorHandle=" + responseProcessorHandle +
                ", url='" + url + '\'' +
                '}';
    }
}
