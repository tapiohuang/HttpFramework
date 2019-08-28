package org.hystudio.httpframework.framework.data.request;

import java.util.LinkedHashSet;

public class RequestHeaders {
    //储存请求数据实体的集合
    private final LinkedHashSet<Object> requestEntityList = new LinkedHashSet<>();

    public LinkedHashSet<Object> getRequestEntityList() {
        return requestEntityList;
    }

    public void addHeader(Object entity) {
        requestEntityList.add(entity);
    }


    public void cleanHeader() {
        requestEntityList.clear();
    }

    private boolean contains(Object entity) {
        return requestEntityList.contains(entity);
    }

    /**
     * @param clazz Class
     * @return Object || null
     */
    private Object getHeaderByType(Class clazz) {
        for (Object o : requestEntityList
        ) {
            if (o.getClass().equals(clazz)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "RequestHeaders{" +
                "requestEntityList=" + requestEntityList +
                '}';
    }
}
