package org.hystudio.httpframework.framework2.reader;

import org.hystudio.httpframework.framework2.config.RequestMethod;
import org.hystudio.httpframework.framework2.reader.IReader;
import org.hystudio.httpframework.framework2.session.HttpSession;

public interface IReaderFactory {
    IReader creatReader(HttpSession httpSession);
}
