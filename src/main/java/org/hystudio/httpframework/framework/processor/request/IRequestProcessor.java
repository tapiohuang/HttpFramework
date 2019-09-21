package org.hystudio.httpframework.framework.processor.request;

import org.hystudio.httpframework.framework.data.RequestData;

public interface IRequestProcessor {
    public void process();

    public Object getResult();

    public RequestData getRequestData();
}
