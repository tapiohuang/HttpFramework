package org.hystudio.httpframework.framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class HttpSessionDefinition {
    private final Method method;
    private final Class[] argsType;
    private final int argNumb;
    private final Annotation[][] argsAnnotations;

    public HttpSessionDefinition(Method method, Class[] argsType, int argNumb, Annotation[][] argsAnnotations) {
        this.method = method;
        this.argsType = argsType;
        this.argNumb = argNumb;
        this.argsAnnotations = argsAnnotations;
    }

    public Method getMethod() {
        return method;
    }

    public Class[] getArgsType() {
        return argsType;
    }

    public int getArgNumb() {
        return argNumb;
    }

    public Annotation[][] getArgsAnnotations() {
        return argsAnnotations;
    }

    @Override
    public String toString() {
        return "HttpSessionDefinition{" +
                "method=" + method +
                ", argsType=" + Arrays.toString(argsType) +
                ", argNumb=" + argNumb +
                ", argsAnnotations=" + Arrays.toString(argsAnnotations) +
                '}';
    }
}
