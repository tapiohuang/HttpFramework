package org.hystudio.httpframework.framework;


import org.hystudio.httpframework.framework.exception.HttpSessionExecuteException;

import java.lang.reflect.Method;

public class HttpSessionFactory {

    private final HttpSessionDefinitionRegistry httpSessionDefinitionRegistry;

    public HttpSessionFactory(HttpSessionDefinitionRegistry httpSessionDefinitionRegistry) {
        this.httpSessionDefinitionRegistry = httpSessionDefinitionRegistry;
    }

    public synchronized HttpSession createHttpSession(Method method, Object[] args) {
        HttpSessionDefinition httpSessionDefinition = httpSessionDefinitionRegistry.getDefinition(method);
        HttpSession httpSession = new HttpSession(httpSessionDefinition, args);
        return httpSession;
    }
}
