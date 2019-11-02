package org.hystudio.httpframework.type;

public enum HTTPVersionType {
    HTTP_1_1("HTTP/1.1");

    private final String httpVersion;

    HTTPVersionType(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public String getMethod() {
        return httpVersion;
    }

}
