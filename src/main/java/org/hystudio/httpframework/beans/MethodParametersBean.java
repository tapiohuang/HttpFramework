package org.hystudio.httpframework.beans;

import org.hystudio.httpframework.processors.IProcessor;
import org.hystudio.httpframework.processors.IRequestProcessor;

import java.util.LinkedList;

public final class MethodParametersBean {
    private final LinkedList<Object> requestEntityObjectList;
    private final LinkedList<Object> requestHeaderObjectList;
    private final LinkedList<IRequestProcessor> requestProcessorList;
    private final LinkedList<IProcessor> responseProcessorList;
    private final LinkedList<Object> requestProxyList;
    private final RequestEntityObjectBean requestEntityObjectBean;

    public MethodParametersBean() {
        requestEntityObjectList = new LinkedList<>();
        requestHeaderObjectList = new LinkedList<>();
        requestProcessorList = new LinkedList<>();
        responseProcessorList = new LinkedList<>();
        requestProxyList = new LinkedList<>();
        requestEntityObjectBean = new RequestEntityObjectBean();
    }

    public LinkedList<Object> getRequestEntityObjectList() {
        return requestEntityObjectList;
    }


    public LinkedList<Object> getRequestHeaderObjectList() {
        return requestHeaderObjectList;
    }


    public LinkedList<IRequestProcessor> getRequestProcessorList() {
        return requestProcessorList;
    }


    public LinkedList<IProcessor> getResponseProcessorList() {
        return responseProcessorList;
    }


    public LinkedList<Object> getRequestProxyList() {
        return requestProxyList;
    }


    @Override
    public String toString() {
        return "MethodParametersBean{" +
                "requestEntityObjectList=" + requestEntityObjectList +
                ", requestHeaderObjectList=" + requestHeaderObjectList +
                ", requestProcessorList=" + requestProcessorList +
                ", responseProcessorList=" + responseProcessorList +
                ", requestProxyList=" + requestProxyList +
                '}';
    }

    public RequestEntityObjectBean getRequestEntityObjectBean() {
        return requestEntityObjectBean;
    }
}
