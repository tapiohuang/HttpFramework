package org.hystudio.httpframework.framework;

public class HttpSessionListener {
    private static HttpSessionListener ourInstance = new HttpSessionListener();

    private HttpSessionListener() {
    }

    public static HttpSessionListener getInstance() {
        return ourInstance;
    }

    public void sendEvent(String msg) {
        System.out.println(msg);
    }

    public void sendEvent(Throwable throwable) {
        System.out.println("执行监听器");
        throwable.printStackTrace();
    }
}
