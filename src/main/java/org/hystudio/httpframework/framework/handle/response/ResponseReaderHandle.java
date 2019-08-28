package org.hystudio.httpframework.framework.handle.response;

import org.hystudio.httpframework.framework.data.HttpRequestDefinition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ResponseReaderHandle implements ResponseHandle {
    private HttpRequestDefinition httpRequestDefinition;

    public ResponseReaderHandle(HttpRequestDefinition httpRequestDefinition) {
        this.httpRequestDefinition = httpRequestDefinition;
    }

    @Override
    public void handle() {
        try {
            readData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readData() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(httpRequestDefinition.getHttpURLConnection().getInputStream(), StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        for (int c; (c = in.read()) >= 0; )
            stringBuilder.append((char) c);
        String response = stringBuilder.toString();
        System.out.println(response);
    }
}
