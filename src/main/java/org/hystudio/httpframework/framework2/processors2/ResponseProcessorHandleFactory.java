package org.hystudio.httpframework.framework2.processors2;


import org.hystudio.httpframework.framework2.session.HttpSession;
import org.hystudio.httpframework.framework2.session.HttpSessionDefinition;

public final class ResponseProcessorHandleFactory implements IResponseProcessorHandleFactory {

    @Override
    public ResponseProcessorsHandle createResponseProcessorsHandle(HttpSession httpSession, Object[] objects, HttpSessionDefinition httpSessionDefinition) {
        int[] responseProcessorOrder = httpSessionDefinition.getResponseProcessorOrder();
        ResponseProcessorsHandle responseProcessorsHandle = new ResponseProcessorsHandle();
        responseProcessorsHandle.setResponseData(httpSession.getResponseData());
        for (int index : responseProcessorOrder
        ) {
            responseProcessorsHandle.addProcessor(((IResponseProcessor) objects[index]));
        }
        if (!responseProcessorsHandle.isHasResponseBodyProcessor()) {
            DefaultResponseProcessor defaultResponseProcessor = new DefaultResponseProcessor();
            responseProcessorsHandle.addProcessor(defaultResponseProcessor);
        }
        if (!responseProcessorsHandle.isHasResponseHeaderProcessor()) {
            DefaultResponseProcessor defaultResponseProcessor = new DefaultResponseProcessor();
            responseProcessorsHandle.addProcessor(defaultResponseProcessor);
        }
        return responseProcessorsHandle;
    }
}
