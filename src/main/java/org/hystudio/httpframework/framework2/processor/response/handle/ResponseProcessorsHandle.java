package org.hystudio.httpframework.framework2.processor.response.handle;


import org.hystudio.httpframework.framework2.data.ResponseData;
import org.hystudio.httpframework.framework2.processor.AbstractProcessorHandle;
import org.hystudio.httpframework.framework2.processor.IProcessor;
import org.hystudio.httpframework.framework2.processor.response.AbstractResponseProcessor;


public class ResponseProcessorsHandle extends AbstractProcessorHandle implements IResponseProcessorHandle {
    private ResponseData responseData;

    @Override
    public void addProcessor(IProcessor processor) {
        AbstractResponseProcessor responseProcessor = (AbstractResponseProcessor) processor;
        processors.add(responseProcessor);
    }

    @Override
    public void addProcessorFirst(IProcessor processor) {
        AbstractResponseProcessor responseProcessor = (AbstractResponseProcessor) processor;
        processors.addFirst(responseProcessor);
    }

    @Override
    public ResponseData getResponseData() {
        return this.responseData;
    }

    @Override
    public void setResponseData(ResponseData responseData) {
        this.processors.forEach(processor -> {
            ((AbstractResponseProcessor) processor).setResponseData(responseData);
        });
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return "ResponseProcessorsHandle{" +
                "responseData=" + responseData +
                ", processors=" + processors +
                '}';
    }
}