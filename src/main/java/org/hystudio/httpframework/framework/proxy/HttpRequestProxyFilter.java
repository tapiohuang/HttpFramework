package org.hystudio.httpframework.framework.proxy;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Cglib 拦截器的过滤器
 * 不拦截toString，，hashCode，equals，clone的方法
 */
public class HttpRequestProxyFilter implements CallbackFilter {
    private static final Set<String> baseMethod = new HashSet<>(Arrays.asList("toString", "hashCode", "equals", "clone"));

    @Override
    public int accept(Method method) {
        String methodName = method.getName();
        if (baseMethod.contains(methodName)) {
            return 0;
        }
        return 1;
    }
}
