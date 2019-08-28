package org.hystudio.httpframework.framework.config;

public enum RequestMethod {
    GET("GET"), POST("POST"), PUT("PUT"), OPTIONS("OPTIONS"), HEAD("HEAD"), DELETE("DELETE");

    private final String method;

    RequestMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }


}
