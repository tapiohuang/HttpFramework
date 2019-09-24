package org.hystudio.httpframework.framework2.processor.response.handle;


import org.hystudio.httpframework.framework2.data.ResponseData;
import org.hystudio.httpframework.framework2.processor.IProcessorHandle;

public interface IResponseProcessorHandle extends IProcessorHandle {
    public ResponseData getResponseData();

    public void setResponseData(ResponseData responseData);
}
