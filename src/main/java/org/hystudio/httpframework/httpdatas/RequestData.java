package org.hystudio.httpframework.httpdatas;

import org.hystudio.httpframework.HttpVersion;
import org.hystudio.httpframework.RequestMethod;

public class RequestData {
    private RequestMethod requestMethod;
    private String url;
    private HttpVersion httpVersion = HttpVersion.HTTP_1_1;
    private RequestHeader requestHeader;
    private RequestBody requestBody;

    public RequestData() {
        this.requestHeader = new RequestHeader(this);
        this.requestBody = new RequestBody(this);
    }

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public RequestBody getRequestBody() {
        return requestBody;
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

    public HttpVersion getHttpVersion() {
        return httpVersion;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "requestMethod=" + requestMethod +
                ", url='" + url + '\'' +
                ", httpVersion=" + httpVersion +
                ", requestHeader=" + requestHeader +
                ", requestBody=" + requestBody +
                '}';
    }
}
