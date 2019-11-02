package org.hystudio.httpframework.type;

public enum HTTPRequestMethodType {
    GET("GET"), POST("POST"), PUT("PUT"), OPTIONS("OPTIONS"), HEAD("HEAD"), DELETE("DELETE");

    private final String method;

    HTTPRequestMethodType(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }


}
