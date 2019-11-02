package org.hystudio.httpframework.farmework;

import java.util.LinkedList;

public final class MethodParameterBean {
    private final LinkedList<Object> requestDataObjectList;
    private final LinkedList<Object> requestHeaderObjectList;
    private final LinkedList<IRequestDataResolver> requestResolverList;
    private final LinkedList<Object> responseResolverList;
    private int objectsNumb;
    private int requestDataNumb;
    private int requestHeaderNumb;
    private int requestResolverNumb;
    private int responseResolverNumb;

    public MethodParameterBean() {
        requestResolverList = new LinkedList<>();
        responseResolverList = new LinkedList<>();
        requestHeaderObjectList = new LinkedList<>();
        requestDataObjectList = new LinkedList<>();
    }


    public int getObjectsNumb() {
        return objectsNumb;
    }

    public void setObjectsNumb(int objectsNumb) {
        this.objectsNumb = objectsNumb;
    }

    public void addRequestData(Object o) {
        this.requestDataObjectList.addLast(o);
        this.requestDataNumb++;
    }

    public void addRequestHeader(Object o) {
        this.requestHeaderObjectList.addLast(o);
        this.requestHeaderNumb++;
    }

    public void addRequestResolver(IRequestDataResolver o) {
        this.requestResolverList.addLast(o);
        this.requestResolverNumb++;
    }

    public void addResponseResolver(Object o) {
        this.responseResolverList.addLast(o);
        this.responseResolverNumb++;
    }

    public int getRequestDataNumb() {
        return requestDataNumb;
    }

    public LinkedList<Object> getRequestDataObjectList() {
        return requestDataObjectList;
    }

    public int getRequestHeaderNumb() {
        return requestHeaderNumb;
    }

    public LinkedList<Object> getRequestHeaderObjectList() {
        return requestHeaderObjectList;
    }

    public int getRequestResolverNumb() {
        return requestResolverNumb;
    }

    public LinkedList<IRequestDataResolver> getRequestResolverList() {
        return requestResolverList;
    }

    public int getResponseResolverNumb() {
        return responseResolverNumb;
    }

    public LinkedList<Object> getResponseResolverList() {
        return responseResolverList;
    }
}
