package org.hystudio.httpframework.framework.processor.request;

import org.hystudio.httpframework.framework.data.RequestData;
import org.hystudio.httpframework.framework.processor.IProcessor;

public interface IRequestProcessor extends IProcessor {

    public RequestData getRequestData();

    public void setRequestData(RequestData requestData);
}
