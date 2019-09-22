package org.hystudio.httpframework.framework.processor.request;

import org.hystudio.httpframework.framework.data.RequestData;

public interface IRequestProcessorHandle {
    public RequestData getRequestData();

    public void setRequestData(RequestData requestData);
}
