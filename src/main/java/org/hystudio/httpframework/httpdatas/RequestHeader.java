package org.hystudio.httpframework.httpdatas;

public class RequestHeader extends AbstractHeader {
    private RequestData requestData;

    RequestHeader(RequestData requestData) {
        this.requestData = requestData;
    }

    public RequestData getRequestData() {
        return requestData;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
