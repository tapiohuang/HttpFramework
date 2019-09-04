package org.hystudio.httpframework.framework.handle.response;

import org.hystudio.httpframework.framework.data.HttpRequestDefinition;
import org.hystudio.httpframework.framework.exception.HttpSessionExecuteException;

public class ResponseReaderHandle extends ResponseDataParserHandle {
    private HttpRequestDefinition httpRequestDefinition;

    public ResponseReaderHandle(HttpRequestDefinition httpRequestDefinition) {
        super(httpRequestDefinition);
        this.httpRequestDefinition = httpRequestDefinition;
    }

    @Override
    public void handle() throws HttpSessionExecuteException {
        super.handle();
    }

}
