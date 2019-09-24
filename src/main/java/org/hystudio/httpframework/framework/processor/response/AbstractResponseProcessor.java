package org.hystudio.httpframework.framework.processor.response;

import org.hystudio.httpframework.framework.data.response.ResponseData;
import org.hystudio.httpframework.framework.processor.AbstractProcessor;
import org.hystudio.httpframework.framework.processor.IProcessor;

public abstract class AbstractResponseProcessor extends AbstractProcessor implements IResponseProcessor {
    protected ResponseData responseData;

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
