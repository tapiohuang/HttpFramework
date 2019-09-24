package org.hystudio.httpframework.framework2.processor.request;


import org.hystudio.httpframework.framework2.data.RequestData;
import org.hystudio.httpframework.framework2.processor.IProcessor;

interface IRequestProcessor extends IProcessor {
    public RequestData getRequestData();

    public void setRequestData(RequestData requestData);

    public void setRequestEntities(Object[] requestEntities);

    public void setRequestHeaders(Object[] requestHeaders);
}
