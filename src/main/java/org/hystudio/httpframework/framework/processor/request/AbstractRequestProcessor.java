package org.hystudio.httpframework.framework.processor.request;

import org.hystudio.httpframework.framework.data.RequestData;
import org.hystudio.httpframework.framework.data.response.ResponseData;
import org.hystudio.httpframework.framework.processor.AbstractProcessor;
import org.hystudio.httpframework.framework.processor.IProcessor;


public abstract class AbstractRequestProcessor extends AbstractProcessor implements IRequestProcessor {
    protected RequestData requestData;

    @Override
    protected void setNextProcessor(Class<? extends IProcessor> processor) {
        this.nextProcessor = processor;
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
