package org.hystudio.httpframework.framework2.processor.request.handle;

import org.hystudio.httpframework.framework2.data.RequestData;
import org.hystudio.httpframework.framework2.processor.AbstractProcessorHandle;
import org.hystudio.httpframework.framework2.processor.IProcessor;
import org.hystudio.httpframework.framework2.processor.request.AbstractRequestProcessor;

public class RequestProcessorsHandle extends AbstractProcessorHandle implements IRequestProcessorHandle {
    protected RequestData requestData;
    protected Object[] objects;

    @Override
    public void addProcessor(IProcessor processor) {
        AbstractRequestProcessor requestProcessor = (AbstractRequestProcessor) processor;
        processors.addLast(requestProcessor);
    }

    @Override
    public void addProcessorFirst(IProcessor processor) {
        AbstractRequestProcessor requestProcessor = (AbstractRequestProcessor) processor;
        processors.addFirst(requestProcessor);
    }

    @Override
    public RequestData getRequestData() {
        return this.requestData;
    }

    @Override
    public void setRequestData(RequestData requestData) {
        this.processors.forEach(processor -> {
            ((AbstractRequestProcessor) processor).setRequestData(requestData);
        });
        this.requestData = requestData;
    }

    @Override
    public String toString() {
        return "RequestProcessorsHandle{" +
                "requestData=" + requestData +
                ", processors=" + processors +
                '}';
    }
}
