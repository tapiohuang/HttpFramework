package org.hystudio.httpframework.framework2.reader;

import org.hystudio.httpframework.framework2.session.HttpSession;

public abstract class AbstractReader implements IReader {
    private HttpSession httpSession;

    protected AbstractReader(HttpSession httpSession) {
        this.httpSession = httpSession;
    }


    @Override
    public abstract void read();
}
