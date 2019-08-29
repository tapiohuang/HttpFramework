package org.hystudio.httpframework.framework.handle.response;

import org.hystudio.httpframework.framework.data.HttpRequestDefinition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ResponseReaderHandle extends ResponseDataHandle implements ResponseHandle {
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
