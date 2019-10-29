package org.hystudio.httpframework.httpdatas;

public class RequestBody extends AbstractBody {
    private RequestData requestData;

    RequestBody(RequestData requestData) {
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
