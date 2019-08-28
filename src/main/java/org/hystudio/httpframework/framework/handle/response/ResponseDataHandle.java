package org.hystudio.httpframework.framework.handle.response;

import org.hystudio.httpframework.framework.data.HttpRequestDefinition;

public abstract class ResponseDataHandle extends ResponseBodyHandle implements ResponseHandle {
    private HttpRequestDefinition httpRequestDefinition;

    public ResponseDataHandle(HttpRequestDefinition httpRequestDefinition) {
        super(httpRequestDefinition);
        this.httpRequestDefinition = httpRequestDefinition;
    }

    @Override
    public void handle() {
        super.handle();
    }
}
