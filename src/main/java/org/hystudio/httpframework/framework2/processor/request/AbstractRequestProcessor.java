package org.hystudio.httpframework.framework2.processor.request;


import org.hystudio.httpframework.framework2.data.RequestData;
import org.hystudio.httpframework.framework2.processor.AbstractProcessor;
import org.hystudio.httpframework.framework2.processor.IProcessor;


public abstract class AbstractRequestProcessor extends AbstractProcessor implements IRequestProcessor {
    protected RequestData requestData;


    AbstractRequestProcessor() {
    }

    @Override
    protected void setNextProcessor(Class<? extends IProcessor> processor) {
        this.nextProcessor = processor;
    }

}
