package org.hystudio.httpframework.framework2.processor.request;

import org.hystudio.httpframework.framework2.data.Header;
import org.hystudio.httpframework.framework2.data.RequestData;

public abstract class AbstractRequestHeaderProcessor extends AbstractRequestProcessor {
    public abstract void setHeader(Header header);

    @Override
    public void setRequestData(RequestData requestData) {
        super.setRequestData(requestData);
        this.setHeader(requestData.getHeader());
    }

    public abstract void setRequestEntities(Object[] requestEntities);

    public abstract void setRequestHeaders(Object[] requestHeaders);
}
