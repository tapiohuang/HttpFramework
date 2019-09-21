package org.hystudio.httpframework.framework.processor.response;

public class DefaultResponseProcessor extends AbstractResponseProcessor {
    @Override
    public void process() {

    }

    @Override
    public Object getResult() {
        return this.result;
    }

    @Override
    public void setProcessResult() {
        this.result = null;
    }
}
