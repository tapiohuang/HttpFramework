package org.hystudio.httpframework.framework.exception;

public class HttpSessionExecuteException extends RuntimeException {
    public HttpSessionExecuteException() {
    }

    public HttpSessionExecuteException(String message) {
        super(message);
    }

    public HttpSessionExecuteException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpSessionExecuteException(Throwable cause) {
        super(cause);
    }

    public HttpSessionExecuteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
