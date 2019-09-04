package org.hystudio.httpframework.framework.interfaces;

import org.hystudio.httpframework.framework.exception.HttpSessionExecuteException;

public interface HttpHandle {
    public void handle() throws HttpSessionExecuteException;
}
