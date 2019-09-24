package org.hystudio.httpframework.framework2.exception;

public class HttpSessionInitException extends RuntimeException {
    public HttpSessionInitException() {
        super();
    }

    public HttpSessionInitException(String message) {
        super(message);
    }

    public HttpSessionInitException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpSessionInitException(Throwable cause) {
        super(cause);
    }

    protected HttpSessionInitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
