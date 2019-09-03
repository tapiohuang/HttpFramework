package org.hystudio.httpframework.framework.handle.response;

import org.hystudio.httpframework.framework.data.HttpRequestDefinition;

public class ResponseReaderHandle extends ResponseDataParserHandle {
    private HttpRequestDefinition httpRequestDefinition;

    public ResponseReaderHandle(HttpRequestDefinition httpRequestDefinition) {
        super(httpRequestDefinition);
        this.httpRequestDefinition = httpRequestDefinition;
    }

    @Override
    public void handle() {
        super.handle();
    }

}
