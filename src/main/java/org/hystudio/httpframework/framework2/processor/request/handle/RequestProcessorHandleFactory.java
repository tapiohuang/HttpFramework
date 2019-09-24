package org.hystudio.httpframework.framework2.processor.request.handle;

import org.hystudio.httpframework.framework2.processor.request.*;
import org.hystudio.httpframework.framework2.session.HttpSessionDefinition;

import java.util.Arrays;


public final class RequestProcessorHandleFactory implements IRequestProcessorHandleFactory {

    @Override
    public RequestProcessorsHandle createRequestProcessorsHandle(Object[] objects, HttpSessionDefinition httpSessionDefinition) {
        boolean hasRequestBodyProcessor = false;
        boolean hasRequestHeaderProcessor = false;
        int[] requestProcessorOrder = httpSessionDefinition.getRequestProcessorOrder();
        int[] requestEntityIndexes = httpSessionDefinition.getRequestEntityIndexes();
        int[] requestHeaderIndexes = httpSessionDefinition.getRequestHeaderIndexes();
        Object[] requestEntities = this.createParameterArr(requestEntityIndexes, objects);
        Object[] requestHeaders = this.createParameterArr(requestHeaderIndexes, objects);
        RequestProcessorsHandle requestProcessorsHandle = new RequestProcessorsHandle();
        for (int index : requestProcessorOrder
        ) {
            AbstractRequestProcessor processor = ((AbstractRequestProcessor) objects[index]);
            processor.setRequestEntities(requestEntities);
            processor.setRequestHeaders(requestHeaders);
            if (processor instanceof AbstractRequestBodyProcessor) {
                hasRequestBodyProcessor = true;
            }
            if (processor instanceof AbstractRequestHeaderProcessor) {
                hasRequestHeaderProcessor = true;
            }
            requestProcessorsHandle.addProcessor(processor);
        }
        if (!hasRequestBodyProcessor) {
            DefaultRequestBodyProcessor defaultRequestBodyProcessor = new DefaultRequestBodyProcessor();
            defaultRequestBodyProcessor.setRequestEntities(requestEntities);
            defaultRequestBodyProcessor.setRequestHeaders(requestHeaders);
            requestProcessorsHandle.addProcessorFirst(defaultRequestBodyProcessor);
        }
        if (!hasRequestHeaderProcessor) {
            DefaultRequestHeaderProcessor defaultRequestHeaderProcessor = new DefaultRequestHeaderProcessor();
            defaultRequestHeaderProcessor.setRequestEntities(requestEntities);
            defaultRequestHeaderProcessor.setRequestHeaders(requestHeaders);
            requestProcessorsHandle.addProcessorFirst(defaultRequestHeaderProcessor);
        }
        return requestProcessorsHandle;
    }

    private Object[] createParameterArr(int[] indexes, Object[] objects) {
        Object[] parameterObjects = new Object[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            parameterObjects[i] = objects[indexes[i]];
        }
        return parameterObjects;
    }
}
