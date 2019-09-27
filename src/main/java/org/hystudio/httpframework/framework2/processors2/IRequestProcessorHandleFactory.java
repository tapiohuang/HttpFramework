package org.hystudio.httpframework.framework2.processor.request.handle;

import org.hystudio.httpframework.framework2.session.HttpSessionDefinition;

public interface IRequestProcessorHandleFactory {
    public RequestProcessorsHandle createRequestProcessorsHandle(Object[] objects, HttpSessionDefinition httpSessionDefinition);
}
