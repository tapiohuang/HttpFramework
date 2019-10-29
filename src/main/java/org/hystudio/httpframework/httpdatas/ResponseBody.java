package org.hystudio.httpframework.httpdatas;

public class ResponseBody extends AbstractBody {
    private ResponseData responseData;

    ResponseBody(ResponseData responseData) {
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
