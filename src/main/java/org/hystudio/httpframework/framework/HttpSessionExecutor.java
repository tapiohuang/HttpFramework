package org.hystudio.httpframework.framework;

import org.hystudio.httpframework.framework.exception.HttpSessionExecuteException;
import org.hystudio.httpframework.framework.handle.RequestHandle;

import java.io.IOException;

public class HttpSessionExecutor implements Executor {
    private HttpSession httpSession;
    private HttpSessionListener httpSessionListener;

    public HttpSessionExecutor(HttpSession httpSession) {
        this.httpSession = httpSession;
        this.httpSessionListener = httpSession.httpSessionListener;
    }

    @Override
    public void run() {
        httpSession.httpSessionLock.executeLock();
        try {
            RequestHandle requestHandle = new RequestHandle();
            httpSession.result = requestHandle.handle(httpSession.method, httpSession.args);
        } catch (HttpSessionExecuteException e) {
            httpSessionListener.sendEvent(e);
        } finally {
            httpSession.httpSessionLock.setStatus(2);
            httpSession.httpSessionLock.unlock();
        }

    }
}
