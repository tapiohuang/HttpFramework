package org.hystudio.httpframework.framework2.session;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

public class HttpSessionConnection {
    private HttpURLConnection httpURLConnection;
    private HttpSession httpSession;

    public HttpSessionConnection(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    public HttpURLConnection getHttpURLConnection() {
        return httpURLConnection;
    }

    public void openConnection(@NotNull URL url) throws IOException {
        this.httpURLConnection = (HttpURLConnection) url.openConnection();
    }

    public void openConnection(@NotNull URL url, Proxy proxy) throws IOException {
        this.httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
    }

    public HttpURLConnection openConnection() throws IOException {
        URL url = new URL(httpSession.getUrl());
        this.httpURLConnection = (HttpURLConnection) url.openConnection();
        return this.httpURLConnection;
    }
}
