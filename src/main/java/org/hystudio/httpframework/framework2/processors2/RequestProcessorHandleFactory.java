package org.hystudio.httpframework.framework2.processors2;

import org.hystudio.httpframework.framework2.session.HttpSession;
import org.hystudio.httpframework.framework2.session.HttpSessionDefinition;


public final class RequestProcessorHandleFactory implements IRequestProcessorHandleFactory {

    @Override
    public RequestProcessorsHandle createRequestProcessorsHandle(HttpSession httpSession, Object[] objects, HttpSessionDefinition httpSessionDefinition) {

        int[] requestProcessorOrder = httpSessionDefinition.getRequestProcessorOrder();
        int[] requestEntityIndexes = httpSessionDefinition.getRequestEntityIndexes();
        int[] requestHeaderIndexes = httpSessionDefinition.getRequestHeaderIndexes();
        int[] requestParameterIndexes = httpSessionDefinition.getRequestParameterIndexes();
        Object[] requestEntities = this.createParameterArr(requestEntityIndexes, objects);
        Object[] requestHeaders = this.createParameterArr(requestHeaderIndexes, objects);
        Object[] parameterEntities = this.createParameterArr(requestParameterIndexes, objects);

        RequestProcessorsHandle requestProcessorsHandle = new RequestProcessorsHandle();
        requestProcessorsHandle.setRequestData(httpSession.getRequestData());
        requestProcessorsHandle.setRequestEntities(requestEntities);
        requestProcessorsHandle.setRequestHeaders(requestHeaders);
        requestProcessorsHandle.setParameterEntities(parameterEntities);

        for (int index : requestProcessorOrder
        ) {
            requestProcessorsHandle.addProcessor(((IRequestProcessor) objects[index]));
        }
        if (!requestProcessorsHandle.isHasRequestBodyProcessor()) {
            DefaultRequestBodyProcessor defaultRequestBodyProcessor = new DefaultRequestBodyProcessor();
            requestProcessorsHandle.addProcessor(defaultRequestBodyProcessor);
        }
        if (!requestProcessorsHandle.isHasRequestHeaderProcessor()) {
            DefaultRequestHeaderProcessor defaultRequestHeaderProcessor = new DefaultRequestHeaderProcessor();
            requestProcessorsHandle.addProcessor(defaultRequestHeaderProcessor);
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
