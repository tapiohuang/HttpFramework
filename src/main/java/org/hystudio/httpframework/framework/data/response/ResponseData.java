package org.hystudio.httpframework.framework.data.response;

import org.hystudio.httpframework.framework.data.HttpHeader;

public class ResponseData {
    private HttpHeader httpHeader;
    private ResponseBody httpResponseBody;
    private int code;

    public ResponseData() {
        httpHeader = new HttpHeader();
        httpResponseBody = new ResponseBody();
    }

    @Override
    public String toString() {
        return "HttpResponseData{" +
                "httpHeader=" + httpHeader +
                ", httpResponseBody=" + httpResponseBody +
                ", code=" + code +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HttpHeader getHttpHeader() {
        return httpHeader;
    }

    public void setHttpHeader(HttpHeader httpHeader) {
        this.httpHeader = httpHeader;
    }

    public ResponseBody getHttpResponseBody() {
        return httpResponseBody;
    }

    public void setHttpResponseBody(ResponseBody httpResponseBody) {
        this.httpResponseBody = httpResponseBody;
    }
}
