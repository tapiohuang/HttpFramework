package org.hystudio.httpframework.framework.processor.response;

import org.hystudio.httpframework.framework.data.response.ResponseData;

public abstract class AbstractResponseProcessor implements IResponseProcessor {
    @SuppressWarnings("WeakerAccess")
    protected ResponseData responseData;
    protected Object result;


    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public abstract void setProcessResult();

    @Override
    public Object getResult() {
        return result;
    }
}
