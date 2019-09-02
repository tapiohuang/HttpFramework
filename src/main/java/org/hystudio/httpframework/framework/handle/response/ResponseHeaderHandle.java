package org.hystudio.httpframework.framework.handle.response;

import org.hystudio.httpframework.framework.data.HttpHeader;
import org.hystudio.httpframework.framework.data.HttpRequestDefinition;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public abstract class ResponseHeaderHandle implements ResponseHandle {
    private HttpHeader httpHeader;
    private HttpRequestDefinition httpRequestDefinition;

    public ResponseHeaderHandle(HttpRequestDefinition httpRequestDefinition) {
        this.httpRequestDefinition = httpRequestDefinition;
        this.httpHeader = httpRequestDefinition.getResponseData().getHttpHeader();
        if (httpHeader == null) {
            httpHeader = new HttpHeader();
            httpRequestDefinition.getResponseData().setHttpHeader(httpHeader);
        }
    }

    @Override
    public void handle() {
        this.readResponseHeader();
    }

    private void readResponseHeader() {
        HttpURLConnection httpURLConnection = this.httpRequestDefinition.getHttpConnection().getHttpURLConnection();
        Map<String, List<String>> headerMap = httpURLConnection.getHeaderFields();
        headerMap.forEach((k, v) -> {
            if (k != null) {
                v.forEach(v1 -> {
                    httpHeader.add(k, v1);
                });
            }
        });
    }
}
