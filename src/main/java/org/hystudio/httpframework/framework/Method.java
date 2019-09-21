package org.hystudio.httpframework.framework;

public enum Method {
    GET("GET"), POST("POST"), PUT("PUT"), OPTIONS("OPTIONS"), HEAD("HEAD"), DELETE("DELETE");

    private final String method;

    Method(String method) {
        this.method = method;
    }

    public String method() {
        return method;
    }

}
