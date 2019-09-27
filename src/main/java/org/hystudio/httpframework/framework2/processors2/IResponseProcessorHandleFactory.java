package org.hystudio.httpframework.framework2.processors2;

import org.hystudio.httpframework.framework2.session.HttpSession;
import org.hystudio.httpframework.framework2.session.HttpSessionDefinition;

public interface IResponseProcessorHandleFactory {
    public ResponseProcessorsHandle createResponseProcessorsHandle(HttpSession httpSession, Object[] objects, HttpSessionDefinition httpSessionDefinition);
}
