package org.hystudio.httpframework.framework;

public class HttpSessionListener {
    private static HttpSessionListener ourInstance = new HttpSessionListener();

    public static HttpSessionListener getInstance() {
        return ourInstance;
    }

    private HttpSessionListener() {
    }
}
