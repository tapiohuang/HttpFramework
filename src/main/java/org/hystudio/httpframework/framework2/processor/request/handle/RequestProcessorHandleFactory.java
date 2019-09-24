package org.hystudio.httpframework.framework2.processor.request;

import org.hystudio.httpframework.framework2.session.HttpSession;
import org.hystudio.httpframework.framework2.session.HttpSessionDefinition;


public final class RequestProcessorHandleFactory implements IRequestProcessorHandleFactory {

    public void createProcessorHandle(Object[] objects, HttpSession httpSession, HttpSessionDefinition httpSessionDefinition) {
        int[] requestProcessorOrder = httpSessionDefinition.getRequestProcessorOrder();
        RequestProcessorsHandle requestProcessorsHandle = new RequestProcessorsHandle();
        requestProcessorsHandle.setRequestData(httpSession.getRequestData());
        for (int index : requestProcessorOrder
        ) {
            requestProcessorsHandle.addProcessor((AbstractRequestProcessor) objects[index]);
        }
        createDefaultProcessorHandle(requestProcessorsHandle);
        httpSession.setRequestProcessorHandle(requestProcessorsHandle);
    }

    /**
     * 添加默认的Processor
     *
     * @param requestProcessorsHandle RequestProcessorsHandle
     */
    private void createDefaultProcessorHandle(RequestProcessorsHandle requestProcessorsHandle) {
        DefaultRequestBodyProcessor defaultRequestBodyProcessor = new DefaultRequestBodyProcessor();
        DefaultRequestHeaderProcessor defaultRequestHeaderProcessor = new DefaultRequestHeaderProcessor();
        requestProcessorsHandle.addProcessor(defaultRequestHeaderProcessor);
        requestProcessorsHandle.addProcessor(defaultRequestBodyProcessor);
    }

    @Override
    public RequestProcessorsHandle createRequestProcessorsHandle(Object[] objects, HttpSessionDefinition httpSessionDefinition) {
        int[] requestProcessorOrder = httpSessionDefinition.getRequestProcessorOrder();
        RequestProcessorsHandle requestProcessorsHandle = new RequestProcessorsHandle();
        for (int index : requestProcessorOrder
        ) {
            requestProcessorsHandle.addProcessor((AbstractRequestProcessor) objects[index]);
        }
        createDefaultProcessorHandle(requestProcessorsHandle);
        return requestProcessorsHandle;
    }
}
