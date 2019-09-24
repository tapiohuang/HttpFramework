package org.hystudio.httpframework.framework.processor.request;

import org.hystudio.httpframework.framework.data.RequestData;
import org.hystudio.httpframework.framework.exception.RequestProcessorInitializeException;
import org.hystudio.httpframework.framework.processor.AbstractProcessorHandle;
import org.hystudio.httpframework.framework.processor.IProcessor;

import java.util.LinkedList;

public class RequestProcessorsHandle extends AbstractProcessorHandle implements IRequestProcessorHandle {
    protected RequestData requestData;

    @Override
    public void addProcessor(IProcessor processor) {
        AbstractRequestProcessor requestProcessor = (AbstractRequestProcessor) processor;
        if (requestData == null) {
            throw new RequestProcessorInitializeException("ResponseData必须先被初始化注入！");
        }
        requestProcessor.setRequestData(requestData);
        processors.add(requestProcessor);
    }

    @Override
    public RequestData getRequestData() {
        return this.requestData;
    }

    @Override
    public void setRequestData(RequestData requestData) {
        this.requestData = requestData;
    }
}
