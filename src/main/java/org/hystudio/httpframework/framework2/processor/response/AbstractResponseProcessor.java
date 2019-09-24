package org.hystudio.httpframework.framework2.processor.response;


import org.hystudio.httpframework.framework2.data.ResponseData;
import org.hystudio.httpframework.framework2.processor.AbstractProcessor;
import org.hystudio.httpframework.framework2.processor.IProcessor;

public abstract class AbstractResponseProcessor extends AbstractProcessor implements IResponseProcessor {
    protected ResponseData responseData;

    AbstractResponseProcessor() {
    }

    @Override
    protected void setNextProcessor(Class<? extends IProcessor> processor) {
        this.nextProcessor = processor;
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
