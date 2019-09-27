package org.hystudio.httpframework.framework2.processors2;

import org.hystudio.httpframework.framework2.data.RequestData;
import org.hystudio.httpframework.framework2.data.ResponseData;
import org.hystudio.httpframework.utils.LogUtils;

import java.util.LinkedList;

public final class ResponseProcessorsHandle implements IProcessorHandle {
    private LinkedList<IResponseProcessor> processors;
    private ResponseData responseData;
    private boolean hasResponseBodyProcessor = false;
    private boolean hasResponseHeaderProcessor = false;
    private Object finalResult;

    public ResponseProcessorsHandle() {
        this.processors = new LinkedList<>();
    }

    public void addProcessor(IResponseProcessor responseProcessor) {
        this.injectObject(responseProcessor);
        processors.addLast(responseProcessor);
    }

    public void addProcessorFirst(IResponseProcessor responseProcessor) {
        this.injectObject(responseProcessor);
        processors.addFirst(responseProcessor);
    }

    public ResponseData getResponseData() {
        return this.responseData;
    }


    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    private void injectObject(IResponseProcessor responseProcessor) {
        if (responseProcessor instanceof IResponseBodyProcessor) {
            this.hasResponseBodyProcessor = true;
            ((IResponseBodyProcessor) responseProcessor).setDataBody(responseData.getDataBody());
        }
        if (responseProcessor instanceof IResponseHeaderProcessor) {
            this.hasResponseHeaderProcessor = true;
            ((IResponseHeaderProcessor) responseProcessor).setHeader(responseData.getHeader());
        }
    }

    @Override
    public void process() {
        ProcessData processData = new ProcessData();
        int index = 0;
        do {
            IResponseProcessor processor = processors.get(index);
            processor.setProcessData(processData);
            processor.process();
            index++;
        } while (index < processors.size());
        this.finalResult = processData.getCurrentResult();
    }

    public boolean isHasResponseBodyProcessor() {
        return hasResponseBodyProcessor;
    }

    public boolean isHasResponseHeaderProcessor() {
        return hasResponseHeaderProcessor;
    }

    public Object getFinalResult() {
        return finalResult;
    }

    @Override
    public String toString() {
        return "ResponseProcessorsHandle{" +
                "processors=" + processors +
                ", responseData=" + responseData +
                ", hasResponseBodyProcessor=" + hasResponseBodyProcessor +
                ", hasResponseHeaderProcessor=" + hasResponseHeaderProcessor +
                ", finalResult=" + finalResult +
                '}';
    }
}
