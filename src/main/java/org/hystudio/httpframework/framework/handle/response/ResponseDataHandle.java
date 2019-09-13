package org.hystudio.httpframework.framework.handle.response;

import org.hystudio.httpframework.framework.data.HttpRequestDefinition;
import org.hystudio.httpframework.framework.data.response.ResponseBody;
import org.hystudio.httpframework.framework.exception.HttpSessionExecuteException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public abstract class ResponseDataHandle extends ResponseHeaderHandle {
    private HttpRequestDefinition httpRequestDefinition;
    private ResponseBody responseBody;

    public ResponseDataHandle(HttpRequestDefinition httpRequestDefinition) {
        super(httpRequestDefinition);
        this.httpRequestDefinition = httpRequestDefinition;
        this.responseBody = httpRequestDefinition.getResponseData().getHttpResponseBody();
    }

    @Override
    public void handle() throws HttpSessionExecuteException {
        super.handle();
        try {
            readData();
        } catch (IOException e) {
            throw new HttpSessionExecuteException(e);
        }
    }

    private void readData() throws IOException {
        HttpURLConnection httpURLConnection = httpRequestDefinition.getHttpConnection().getHttpURLConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        char[] tmp = new char[1024];
        while (in.read(tmp) != -1) {
            for (char c : tmp
            ) {
                if ((int) c == 0) {
                    break;
                }
                stringBuilder.append(c);
            }
        }
        String response = stringBuilder.toString();
        responseBody.set(response);
    }
}
