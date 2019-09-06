package org.hystudio.httpframework.framework;

import org.hystudio.httpframework.framework.exception.HttpSessionExecuteException;
import org.hystudio.httpframework.framework.handle.RequestHandle;
import org.hystudio.httpframework.framework.interfaces.Executor;

import java.lang.reflect.Method;

/**
 * 请求会话
 * 定义数据
 */
public class HttpSession {
    private final Method method;
    private final Class[] argsTypes;
    private final int argNumb;
    private final HttpSessionExecutor httpSessionExecutor;
    private final Object[] args;
    private final HttpSessionLock httpSessionLock;
    private int status;
    private HttpSessionListener httpSessionListener;
    private Object result;

    public HttpSession(HttpSessionDefinition httpSessionDefinition, Object[] args) {
        this.method = httpSessionDefinition.getMethod();
        this.argsTypes = httpSessionDefinition.getArgsType();
        this.argNumb = httpSessionDefinition.getArgNumb();
        this.args = args;
        this.status = 0;
        this.httpSessionListener = HttpSessionListener.getInstance();
        this.httpSessionLock = new HttpSessionLock();
        this.httpSessionExecutor = new HttpSessionExecutor(this);
    }

    HttpSessionExecutor getHttpSessionExecutor() {
        return httpSessionExecutor;
    }

    public Object readResult() {
        httpSessionLock.readLock();
        return result;
    }

    private static class HttpSessionExecutor implements Executor {
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
}
