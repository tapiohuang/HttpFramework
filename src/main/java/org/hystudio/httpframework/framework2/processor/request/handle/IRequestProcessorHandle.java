package org.hystudio.httpframework.framework2.processor.request.handle;


import org.hystudio.httpframework.framework2.data.RequestData;
import org.hystudio.httpframework.framework2.processor.IProcessorHandle;

public interface IRequestProcessorHandle extends IProcessorHandle {
    public RequestData getRequestData();

    public void setRequestData(RequestData requestData);

}
