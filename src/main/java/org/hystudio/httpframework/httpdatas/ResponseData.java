package org.hystudio.httpframework.httpdatas;

import org.hystudio.httpframework.HttpMessage;
import org.hystudio.httpframework.HttpVersion;

public class ResponseData {
    private HttpVersion httpVersion = HttpVersion.HTTP_1_1;
    private int statusCode = -1;
    private HttpMessage httpMessage;
    private ResponseHeader responseHeader;
    private ResponseBody responseBody;

    public ResponseData() {
        this.responseHeader = new ResponseHeader(this);
        this.responseBody = new ResponseBody(this);
    }

    public HttpVersion getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(HttpVersion httpVersion) {
        this.httpVersion = httpVersion;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public HttpMessage getHttpMessage() {
        return httpMessage;
    }

    public void setHttpMessage(HttpMessage httpMessage) {
        this.httpMessage = httpMessage;
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public ResponseBody getResponseBody() {
        return responseBody;
    }
}
