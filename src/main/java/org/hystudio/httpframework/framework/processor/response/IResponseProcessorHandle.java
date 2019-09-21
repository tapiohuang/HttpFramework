package org.hystudio.httpframework.framework.processor.response;

import org.hystudio.httpframework.framework.data.RequestData;
import org.hystudio.httpframework.framework.data.response.ResponseData;

public interface IResponseProcessorHandle {
    public ResponseData getResponseData();

    public void setResponseData(ResponseData responseData);
}
