package org.hystudio.httpframework.framework.data;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class HttpProxy {
    private final Proxy proxy;

    public HttpProxy(String host, int port) {
        this.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port));
    }

    public Proxy getProxy() {
        return proxy;
    }

    @Override
    public String toString() {
        return "HttpProxy{" +
                "proxy=" + proxy +
                '}';
    }
}
