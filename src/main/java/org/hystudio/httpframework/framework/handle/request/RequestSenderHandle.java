package org.hystudio.httpframework.framework.handle.request;


import org.hystudio.httpframework.framework.config.RequestMethod;
import org.hystudio.httpframework.framework.data.HttpRequestDefinition;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.util.Arrays;

public class RequestSenderHandle extends RequestDataHandle implements RequestHandle {
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
            sendData();
            httpRequestDefinition.setHttpURLConnection(this.httpURLConnection);
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
        //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888));
        //this.httpURLConnection = (HttpURLConnection) HttpUrl.openConnection(proxy);
        this.httpURLConnection = (HttpURLConnection) HttpUrl.openConnection();
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
}
