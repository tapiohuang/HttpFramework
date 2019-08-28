package org.hystudio.httpframework.framework.handle.response;

import org.hystudio.httpframework.framework.data.HttpRequestDefinition;
import org.hystudio.httpframework.framework.data.response.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public abstract class ResponseBodyHandle extends ResponseHeaderHandle implements ResponseHandle {
    private ResponseBody responseBody;
    private HttpRequestDefinition httpRequestDefinition;

    public ResponseBodyHandle(HttpRequestDefinition httpRequestDefinition) {
        super(httpRequestDefinition);
        this.httpRequestDefinition = httpRequestDefinition;
        this.responseBody = httpRequestDefinition.getResponseData().getHttpResponseBody();
    }

    @Override
    public void handle() {
        super.handle();
        try {
            readData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readData() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        for (int c; (c = in.read()) >= 0; )
            stringBuilder.append((char) c);
        String response = stringBuilder.toString();
        responseBody.set(response);
    }
}
