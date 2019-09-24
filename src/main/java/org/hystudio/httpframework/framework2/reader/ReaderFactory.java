package org.hystudio.httpframework.framework2;


import org.hystudio.httpframework.framework2.reader.DefaultReader;
import org.hystudio.httpframework.framework2.reader.IReader;
import org.hystudio.httpframework.framework2.session.HttpSession;

public final class ReaderFactory implements IReaderFactory {


    @Override
    public IReader creatReader(HttpSession httpSession) {
        return new DefaultReader();
    }
}
