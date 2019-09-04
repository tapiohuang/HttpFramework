package org.hystudio.httpframework.framework;

import java.lang.reflect.Method;
import java.util.HashMap;

public class HttpSessionDefinitionRegistry {
    private final HashMap<Method, HttpSessionDefinition> httpSessionDefinitionHashMap;

    public HttpSessionDefinitionRegistry() {
        this.httpSessionDefinitionHashMap = new HashMap<>();
    }

    public void addDefinition(HttpSessionDefinition httpSessionDefinition) {
        httpSessionDefinitionHashMap.put(httpSessionDefinition.getMethod(), httpSessionDefinition);
    }

    public HttpSessionDefinition getDefinition(Method method) {
        return httpSessionDefinitionHashMap.get(method);
    }
}
