package org.hystudio.httpframework.framework2.reader;


import org.hystudio.httpframework.framework2.session.HttpSession;

public final class ReaderFactory implements IReaderFactory {

    @Override
    public IReader creatReader(HttpSession httpSession) {
        return new DefaultReader(httpSession);
    }
}
