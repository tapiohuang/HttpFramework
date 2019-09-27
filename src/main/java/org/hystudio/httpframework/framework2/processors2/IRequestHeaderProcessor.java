package org.hystudio.httpframework.framework2.processors2;


import org.hystudio.httpframework.framework2.data.Header;

public interface IRequestHeaderProcessor extends IRequestProcessor {
    public void setRequestHeaders(Object[] requestHeaders);

    public void setHeader(Header header);
}
