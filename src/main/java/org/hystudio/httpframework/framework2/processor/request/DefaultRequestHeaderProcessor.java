package org.hystudio.httpframework.framework2.processor.request;


import org.hystudio.httpframework.framework2.data.Header;

import java.util.Arrays;

public class DefaultRequestHeaderProcessor extends AbstractRequestHeaderProcessor {
    private Header header;
    private Object[] requestEntities;
    private Object[] requestHeaders;

    @Override
    public void process() {

    }

    @Override
    public void setHeader(Header header) {
        this.header = header;
    }

    @Override
    public void setRequestEntities(Object[] requestEntities) {
        this.requestEntities = requestEntities;
    }

    @Override
    public void setRequestHeaders(Object[] requestHeaders) {
        this.requestHeaders = requestHeaders;
    }
}
