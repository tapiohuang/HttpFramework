package org.hystudio.httpframework.framework.processor.response;

import org.hystudio.httpframework.framework.data.RequestData;
import org.hystudio.httpframework.framework.data.response.ResponseData;
import org.hystudio.httpframework.framework.processor.IProcessor;

public interface IResponseProcessor extends IProcessor {

    public ResponseData getResponseData();

    public void setResponseData(ResponseData responseData);

}
