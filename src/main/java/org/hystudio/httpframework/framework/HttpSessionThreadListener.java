package org.hystudio.httpframework.framework;

/**
 * 监听处理HttpSession进程
 */
public class HttpSessionThreadListener {
    private static HttpSessionThreadListener ourInstance = new HttpSessionThreadListener();

    private HttpSessionThreadListener() {
    }

    public static HttpSessionThreadListener getInstance() {
        return ourInstance;
    }
}
