package org.hystudio.httpframework.farmework;

public class RequestData {
    private final HTTPBody httpBody;
    private final HTTPHeader httpHeader;

    public RequestData() {
        httpHeader = new HTTPHeader();
        httpBody = new HTTPBody();
    }

    public HTTPBody getHttpBody() {
        return httpBody;
    }

    public HTTPHeader getHttpHeader() {
        return httpHeader;
    }
}
