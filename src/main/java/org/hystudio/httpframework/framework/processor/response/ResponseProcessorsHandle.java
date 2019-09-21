package org.hystudio.httpframework.framework.processor.response;

import org.hystudio.httpframework.framework.data.RequestData;
import org.hystudio.httpframework.framework.data.response.ResponseData;
import org.hystudio.httpframework.framework.exception.ResponseProcessorInitializeException;

import java.util.LinkedList;

public class ResponseProcessorsHandle implements IResponseProcessor {
    private LinkedList<AbstractResponseProcessor> responseProcessors;
    private ResponseData responseData;

    public ResponseProcessorsHandle() {
        this.responseProcessors = new LinkedList<>();
    }

    public void setRequestData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public void addProcessor(AbstractResponseProcessor responseProcessor) {
        if (responseData == null) {
            throw new ResponseProcessorInitializeException("ResponseData must be initialized before ResponseProcessorList initialize");
        }
        responseProcessor.setResponseData(responseData);
        this.responseProcessors.add(responseProcessor);
    }


    @Override
    public void process() {
        int index = 0;
        do {
            AbstractResponseProcessor processor = responseProcessors.get(index);
            processor.process();
            index++;
        } while (index < responseProcessors.size());
    }

    @Override
    public Object getResult() {
        return responseProcessors.getLast().getResult();
    }
}
