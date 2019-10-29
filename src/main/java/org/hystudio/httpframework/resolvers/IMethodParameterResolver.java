package org.hystudio.httpframework.resolvers;

import org.hystudio.httpframework.beans.MethodParametersBean;

import java.lang.annotation.Annotation;

public interface IMethodParameterResolver {
    public void setObjects(Object[] objects);

    public void setMethodParameterAnnotations(Annotation[][] parameterAnnotations);

    public void setMethodParametersBean(MethodParametersBean methodParametersBean);
}
