package org.hystudio.httpframework.framework2.processor.request;


import org.hystudio.httpframework.framework2.data.DataBody;


public class DefaultRequestBodyProcessor extends AbstractRequestBodyProcessor {
    private Object[] requestEntities;
    private Object[] requestHeaders;
    private DataBody dataBody;


    @Override
    public void process() {

    }

    @Override
    public void setDataBody(DataBody dataBody) {
        this.dataBody = dataBody;
    }

    @Override
    public void setRequestEntities(Object[] requestEntities) {
        this.requestEntities = requestEntities;
    }

    @Override
    public void setRequestHeaders(Object[] requestHeaders) {
        this.requestHeaders = requestHeaders;
    }
}
