package org.hystudio.httpframework.framework.handle.request;

import org.hystudio.httpframework.framework.data.HttpRequestDefinition;
import org.hystudio.httpframework.framework.data.request.RequestData;
import org.hystudio.httpframework.framework.interfaces.ContentParser;
import org.hystudio.httpframework.framework.interfaces.HttpHandle;


public abstract class RequestDataHandle extends RequestHeaderHandle implements HttpHandle {
    private RequestData requestData;

    private HttpRequestDefinition httpRequestDefinition;

    public RequestDataHandle(HttpRequestDefinition httpRequestDefinition) {
        super(httpRequestDefinition);
        this.httpRequestDefinition = httpRequestDefinition;
        this.requestData = httpRequestDefinition.getRequestData();
    }

    @Override
    public void handle() {
        super.handle();
        requestDataHandle();
    }

    public void requestDataHandle() {
        ContentParser contentParser = httpRequestDefinition.getContentParser();
        contentParser.setRequestEntities(this.httpRequestDefinition.getRequestEntities());
        contentParser.setRequestBody(this.httpRequestDefinition.getRequestData().getRequestBody());
        contentParser.parser();
    }
}
