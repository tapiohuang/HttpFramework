package org.hystudio.httpframework.framework2.processor.response.handle;

import org.hystudio.httpframework.framework2.session.HttpSessionDefinition;

public interface IResponseProcessorHandleFactory {
    public ResponseProcessorsHandle createResponseProcessorsHandle(Object[] objects, HttpSessionDefinition httpSessionDefinition);
}
