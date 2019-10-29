package org.hystudio.httpframework.httpdatas;

public class ResponseHeader extends AbstractHeader {
    private ResponseData responseData;

    ResponseHeader(ResponseData responseData) {
        this.responseData = responseData;
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
