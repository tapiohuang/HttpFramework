package org.hystudio.httpframework.framework.processor.request;

import org.hystudio.httpframework.framework.data.RequestData;
import org.hystudio.httpframework.framework.data.response.ResponseData;

public abstract class AbstractRequestProcessor implements IRequestProcessor {
    @SuppressWarnings("WeakerAccess")
    protected RequestData requestData;
    protected Object result;


    public void setResponseData(RequestData requestData) {
        this.requestData = requestData;
    }

    public abstract void setProcessResult();

    @Override
    public Object getResult() {
        return result;
    }

    @Override
    public RequestData getRequestData() {
        return this.requestData;
    }
}
