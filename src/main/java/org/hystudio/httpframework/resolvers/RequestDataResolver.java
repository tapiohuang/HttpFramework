package org.hystudio.httpframework.resolvers;

import org.hystudio.httpframework.beans.RequestEntityObjectBean;
import org.hystudio.httpframework.httpdatas.RequestData;
import org.hystudio.httpframework.processors.*;
import org.hystudio.httpframework.utils.LogUtils;

import java.util.LinkedList;

public class RequestDataResolver implements
        IResolver, IProcessorResolver<IRequestProcessor>, IRequestDataResolver, IExecutableResolver {
    private LinkedList<IRequestProcessor> requestProcessorList;
    private LinkedList<Object> requestEntityObjectList;
    private LinkedList<Object> requestHeaderObjectList;
    private ProcessData processData;
    private RequestData requestData;
    private boolean hasRequestHeaderProcessor = false;
    private boolean hasRequestBodyProcessor = false;
    private RequestEntityObjectBean requestEntityObjectBean;

    @Override
    public void resolver() {
        this.processData = new ProcessData();
        this.injectData();
    }


    @Override
    public void setProcessorList(LinkedList<IRequestProcessor> processorList) {
        this.requestProcessorList = processorList;
    }


    private void injectData() {
        for (IProcessor processor : requestProcessorList
        ) {
            processor.setProcessData(this.processData);
            if (processor instanceof IRequestHeaderProcessor) {
                this.hasRequestHeaderProcessor = true;
                ((IRequestHeaderProcessor) processor).setRequestHeaderObjectList(this.requestHeaderObjectList);
                ((IRequestHeaderProcessor) processor).setRequestHeader(this.requestData.getRequestHeader());
            }
            if (processor instanceof IRequestBodyProcessor) {
                this.hasRequestBodyProcessor = true;
                ((IRequestBodyProcessor) processor).setRequestEntityObjectList(this.requestEntityObjectList);
                ((IRequestBodyProcessor) processor).setRequestBody(this.requestData.getRequestBody());
            }
        }
        if (!this.hasRequestBodyProcessor) {
            this.addDefaultRequestBodyProcessor();
        }
        if (!this.hasRequestHeaderProcessor) {
            this.addDefaultRequestHeaderProcessor();
        }
    }

    private void addDefaultRequestHeaderProcessor() {
        DefaultRequestHeaderProcessor defaultRequestHeaderProcessor = new DefaultRequestHeaderProcessor();
        defaultRequestHeaderProcessor.setRequestHeaderObjectList(this.requestHeaderObjectList);
        defaultRequestHeaderProcessor.setRequestHeader(this.requestData.getRequestHeader());
        this.requestProcessorList.add(defaultRequestHeaderProcessor);

        DefaultRequestHeaderPostProcessor defaultRequestHeaderPostProcessor = new DefaultRequestHeaderPostProcessor();
        defaultRequestHeaderPostProcessor.setRequestHeaderObjectList(this.requestHeaderObjectList);
        defaultRequestHeaderPostProcessor.setRequestHeader(this.requestData.getRequestHeader());
        this.requestProcessorList.addLast(defaultRequestHeaderPostProcessor);
    }

    private void addDefaultRequestBodyProcessor() {
        DefaultRequestBodyProcessor defaultRequestBodyProcessor = new DefaultRequestBodyProcessor();
        defaultRequestBodyProcessor.setRequestEntityObjectList(this.requestEntityObjectList);
        defaultRequestBodyProcessor.setRequestBody(this.requestData.getRequestBody());
        this.requestProcessorList.add(defaultRequestBodyProcessor);
    }

    private void runProcessor() {
        for (IProcessor processor : requestProcessorList
        ) {
            processor.process();
        }
    }

    @Override
    public void setRequestData(RequestData requestData) {
        this.requestData = requestData;
    }

    @Override
    public void setRequestEntityObjectList(LinkedList<Object> requestEntityObjectList) {
        this.requestEntityObjectList = requestEntityObjectList;
    }

    @Override
    public void setRequestHeaderObjectList(LinkedList<Object> requestHeaderObjectList) {
        this.requestHeaderObjectList = requestHeaderObjectList;
    }

    @Override
    public void setRequestEntityObjectBean(RequestEntityObjectBean requestEntityObjectBean) {
        this.requestEntityObjectBean = requestEntityObjectBean;
    }

    @Override
    public String toString() {
        return "RequestResolver{" +
                "requestProcessorList=" + requestProcessorList +
                ", requestEntityObjectList=" + requestEntityObjectList +
                ", requestHeaderObjectList=" + requestHeaderObjectList +
                ", processData=" + processData +
                ", requestData=" + requestData +
                ", hasRequestHeaderProcessor=" + hasRequestHeaderProcessor +
                ", hasRequestBodyProcessor=" + hasRequestBodyProcessor +
                '}';
    }

    @Override
    public void execute() {
        this.runProcessor();
        LogUtils.info("requestHeader", this.requestData.getRequestHeader());
    }
}
