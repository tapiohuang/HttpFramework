package org.hystudio.httpframework.framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class HttpSessionTemplate {
    private Method method;
    private Class[] argsType;
    private int argNumb;
    private Annotation[][] argsAnnotations;

    public HttpSessionTemplate(Method method, Class[] argsType, int argNumb, Annotation[][] argsAnnotations) {
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

    @Override
    public String toString() {
        return "HttpSessionTemplate{" +
                "method=" + method +
                ", argsType=" + Arrays.toString(argsType) +
                ", argNumb=" + argNumb +
                '}';
    }

    public Annotation[][] getArgsAnnotations() {
        return argsAnnotations;
    }

    public void setArgsAnnotations(Annotation[][] argsAnnotations) {
        this.argsAnnotations = argsAnnotations;
    }
}
