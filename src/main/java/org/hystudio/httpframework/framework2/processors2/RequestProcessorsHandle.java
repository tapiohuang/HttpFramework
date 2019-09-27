package org.hystudio.httpframework.framework2.processors2;


import org.hystudio.httpframework.framework2.data.RequestData;
import org.hystudio.httpframework.framework2.processor.AbstractProcessor;

import java.util.LinkedList;

public final class RequestProcessorsHandle implements IProcessorHandle {
    private LinkedList<IRequestProcessor> processors;
    private Object[] requestEntities;
    private Object[] requestHeaders;
    private Object[] parameterEntities;
    private RequestData requestData;
    private boolean hasRequestBodyProcessor = false;
    private boolean hasRequestHeaderProcessor = false;
    private Object finalResult;

    public RequestProcessorsHandle() {
        this.processors = new LinkedList<>();
    }

    public void addProcessor(IRequestProcessor requestProcessor) {
        this.injectObject(requestProcessor);
        processors.addLast(requestProcessor);
    }

    public void addProcessorFirst(IRequestProcessor requestProcessor) {
        this.injectObject(requestProcessor);
        processors.addFirst(requestProcessor);
    }

    public RequestData getRequestData() {
        return this.requestData;
    }


    public void setRequestData(RequestData requestData) {
        this.requestData = requestData;
    }

    private void injectObject(IRequestProcessor requestProcessor) {
        if (requestProcessor instanceof IRequestBodyProcessor) {
            this.hasRequestBodyProcessor = true;
            ((IRequestBodyProcessor) requestProcessor).setRequestEntities(requestEntities);
            ((IRequestBodyProcessor) requestProcessor).setDataBody(requestData.getDataBody());
        }
        if (requestProcessor instanceof IRequestHeaderProcessor) {
            this.hasRequestHeaderProcessor = true;
            ((IRequestHeaderProcessor) requestProcessor).setRequestHeaders(requestHeaders);
            ((IRequestHeaderProcessor) requestProcessor).setHeader(requestData.getHeader());
        }
        if (requestProcessor instanceof IRequestParameterProcessor) {
            this.hasRequestHeaderProcessor = true;
            ((IRequestParameterProcessor) requestProcessor).setParameterEntities(parameterEntities);
            ((IRequestParameterProcessor) requestProcessor).setParameter(requestData.getParameter());
        }
    }

    @Override
    public void process() {
        ProcessData processData = new ProcessData();
        int index = 0;
        do {
            IRequestProcessor processor = processors.get(index);
            processor.setProcessData(processData);
            processor.process();
            index++;
        } while (index < processors.size());
        this.finalResult = processData.getCurrentResult();
    }

    public void setRequestEntities(Object[] requestEntities) {
        this.requestEntities = requestEntities;
    }

    public void setRequestHeaders(Object[] requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public boolean isHasRequestBodyProcessor() {
        return hasRequestBodyProcessor;
    }

    public boolean isHasRequestHeaderProcessor() {
        return hasRequestHeaderProcessor;
    }

    public void setParameterEntities(Object[] parameterEntities) {
        this.parameterEntities = parameterEntities;
    }
}
