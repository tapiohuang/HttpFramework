package org.hystudio.httpframework.framework.data.request;

import org.hystudio.httpframework.framework.data.HttpHeader;

public class RequestData {
    private HttpHeader httpHeader;
    private RequestBody requestBody;

    public RequestData() {
        this.httpHeader = new HttpHeader();
        this.requestBody = new RequestBody();
    }

    public HttpHeader getHttpHeader() {
        return httpHeader;
    }

    public void setHttpHeader(HttpHeader httpHeader) {
        this.httpHeader = httpHeader;
    }


    public RequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "httpHeader=" + httpHeader +
                ", requestBody=" + requestBody +
                '}';
    }
}
