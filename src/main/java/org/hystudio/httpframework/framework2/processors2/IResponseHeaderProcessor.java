package org.hystudio.httpframework.framework2.processors2;

import org.hystudio.httpframework.framework2.data.Header;

public interface IResponseHeaderProcessor extends IResponseProcessor {
    public void setHeader(Header header);
}
