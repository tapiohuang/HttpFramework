package org.hystudio.httpframework;

public enum HttpVersion {
    HTTP_1_1("HTTP/1.1");

    private final String httpVersion;

    HttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public String getMethod() {
        return httpVersion;
    }

}
