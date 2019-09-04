package org.hystudio.httpframework.framework;

import java.lang.reflect.Method;

/**
 * 请求会话
 * 定义数据
 */
public class HttpSession {
    final Method method;
    final Class[] argsTypes;
    final int argNumb;
    final HttpSessionExecutor httpSessionExecutor;
    final Object[] args;
    //final Object httpSessionLock;
    final HttpSessionLock httpSessionLock;
    int status;
    HttpSessionListener httpSessionListener;
    Object result;

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

    public HttpSessionExecutor getHttpSessionExecutor() {
        return httpSessionExecutor;
    }

    public Object readResult() {
        httpSessionLock.readLock();
        return result;
    }
}
