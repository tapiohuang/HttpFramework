package org.hystudio.httpframework.framework.exception;

public class HttpSessionLockException extends RuntimeException {
    public HttpSessionLockException() {
    }

    public HttpSessionLockException(String message) {
        super(message);
    }

    public HttpSessionLockException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpSessionLockException(Throwable cause) {
        super(cause);
    }

    public HttpSessionLockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
