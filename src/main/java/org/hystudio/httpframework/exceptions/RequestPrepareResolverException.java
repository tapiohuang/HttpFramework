package org.hystudio.httpframework.exceptions;

public class RequestPrepareResolverException extends RuntimeException {
    public RequestPrepareResolverException() {
        super();
    }

    public RequestPrepareResolverException(String message) {
        super(message);
    }

    public RequestPrepareResolverException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestPrepareResolverException(Throwable cause) {
        super(cause);
    }

    protected RequestPrepareResolverException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
