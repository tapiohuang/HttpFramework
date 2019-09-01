package org.hystudio.httpframework.framework.handle.response;

import org.hystudio.httpframework.framework.data.HttpRequestDefinition;

public abstract class ResponseParserHandle extends ResponseDataHandle {
    private HttpRequestDefinition httpRequestDefinition;

    public ResponseParserHandle(HttpRequestDefinition httpRequestDefinition) {
        super(httpRequestDefinition);
        this.httpRequestDefinition = httpRequestDefinition;
    }

    @Override
    public void handle() {
        super.handle();
    }
}
