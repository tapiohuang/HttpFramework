package org.hystudio.httpframework.framework.processor.response;

import org.hystudio.httpframework.framework.data.response.ResponseData;
import org.hystudio.httpframework.framework.exception.ResponseProcessorInitializeException;
import org.hystudio.httpframework.framework.processor.AbstractProcessorHandle;
import org.hystudio.httpframework.framework.processor.IProcessor;


public class ResponseProcessorsHandle extends AbstractProcessorHandle implements IResponseProcessorHandle {
    private ResponseData responseData;

    @Override
    public void addProcessor(IProcessor processor) {
        AbstractResponseProcessor responseProcessor = (AbstractResponseProcessor) processor;
        if (responseData == null) {
            throw new ResponseProcessorInitializeException("ResponseData必须先被初始化注入！");
        }
        responseProcessor.setResponseData(responseData);
        processors.add(responseProcessor);
    }

    @Override
    public ResponseData getResponseData() {
        return this.responseData;
    }

    @Override
    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }
}
