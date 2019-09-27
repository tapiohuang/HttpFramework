package org.hystudio.httpframework.framework2.processors2;

import org.hystudio.httpframework.framework2.session.HttpSession;
import org.hystudio.httpframework.framework2.session.HttpSessionDefinition;

public interface IRequestProcessorHandleFactory {
    public RequestProcessorsHandle createRequestProcessorsHandle(HttpSession httpSession, Object[] objects, HttpSessionDefinition httpSessionDefinition);
}
