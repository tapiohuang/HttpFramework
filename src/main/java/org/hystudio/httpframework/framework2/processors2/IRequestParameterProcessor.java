package org.hystudio.httpframework.framework2.processors2;

import org.hystudio.httpframework.framework2.data.Parameter;

public interface IRequestParameterProcessor extends IRequestProcessor {
    public void setParameter(Parameter parameter);

    public void setParameterEntities(Object[] parameterEntities);
}
