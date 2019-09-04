package org.hystudio.httpframework.framework;

public class HttpSessionThreadListener {
    private static HttpSessionThreadListener ourInstance = new HttpSessionThreadListener();

    public static HttpSessionThreadListener getInstance() {
        return ourInstance;
    }

    private HttpSessionThreadListener() {
    }
}
