package org.hystudio.httpframework.framework2.processor.response.handle;

import org.hystudio.httpframework.framework2.processor.response.AbstractResponseProcessor;
import org.hystudio.httpframework.framework2.session.HttpSessionDefinition;

public final class ResponseProcessorHandleFactory implements IResponseProcessorHandleFactory {

    @Override
    public ResponseProcessorsHandle createResponseProcessorsHandle(Object[] objects, HttpSessionDefinition httpSessionDefinition) {
        int[] responseProcessorOrder = httpSessionDefinition.getResponseProcessorOrder();
        ResponseProcessorsHandle responseProcessorsHandle = new ResponseProcessorsHandle();
        for (int index : responseProcessorOrder
        ) {
            AbstractResponseProcessor processor = ((AbstractResponseProcessor) objects[index]);
            responseProcessorsHandle.addProcessor(processor);
        }
        return new ResponseProcessorsHandle();
    }
}
