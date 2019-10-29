package org.hystudio.httpframework.exceptions;

public class CreateRequestBeanProxyException extends RuntimeException {
    public CreateRequestBeanProxyException() {
        super();
    }

    public CreateRequestBeanProxyException(String message) {
        super(message);
    }

    public CreateRequestBeanProxyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateRequestBeanProxyException(Throwable cause) {
        super(cause);
    }
}
