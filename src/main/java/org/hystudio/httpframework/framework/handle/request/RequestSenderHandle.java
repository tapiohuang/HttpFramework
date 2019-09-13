package org.hystudio.httpframework.framework.handle.request;


import org.hystudio.httpframework.framework.config.RequestMethod;
import org.hystudio.httpframework.framework.data.HttpRequestDefinition;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

public class RequestSenderHandle extends RequestDataHandle {
    private HttpRequestDefinition httpRequestDefinition;
    private HttpURLConnection httpURLConnection;

    public RequestSenderHandle(HttpRequestDefinition httpRequestDefinition) {
        super(httpRequestDefinition);
        this.httpRequestDefinition = httpRequestDefinition;
    }

    @Override
    public void handle() {
        super.handle();
        try {
            prepareConnection();
            parserHeader();
            if (httpRequestDefinition.getRequestMethod() == RequestMethod.GET) {
                getData();
            } else {
                sendData();
            }
            httpRequestDefinition.getHttpConnection().setHttpURLConnection(this.httpURLConnection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void prepareConnection() throws IOException {
        String url = httpRequestDefinition.getRequestUrl();
        if (httpRequestDefinition.getRequestMethod() == RequestMethod.GET) {
            url += "?" + httpRequestDefinition.getRequestData().getRequestBody().readToString();
        }
        URL HttpUrl = new URL(url);
        if (httpRequestDefinition.getHttpProxy() == null) {
            this.httpURLConnection = (HttpURLConnection) HttpUrl.openConnection();
        } else {
            this.httpURLConnection = (HttpURLConnection) HttpUrl.openConnection(httpRequestDefinition.getHttpProxy().getProxy());
        }
        httpURLConnection.setRequestMethod(httpRequestDefinition.getRequestMethod().getMethod());
        httpURLConnection.setReadTimeout(httpRequestDefinition.getTimeout());
        httpURLConnection.setConnectTimeout(httpRequestDefinition.getTimeout());
    }

    private void parserHeader() {
        httpRequestDefinition.getRequestData().getHttpHeader().getHeaderMap().forEach((k, v) -> {
            httpURLConnection.addRequestProperty(k, v);
        });
    }


    private void sendData() throws IOException {
        this.httpURLConnection.setDoInput(true);
        this.httpURLConnection.setDoOutput(true);
        this.httpURLConnection.setUseCaches(false);
        this.httpURLConnection.connect();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(httpRequestDefinition.getRequestData().getRequestBody().readToBytes());
        outputStream.flush();
        outputStream.close();
    }

    private void getData() throws IOException {
        this.httpURLConnection.connect();
    }
}
