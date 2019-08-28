package org.hystudio.httpframework.framework.data.request;

import java.util.LinkedHashSet;

public class RequestEntities {
    //储存请求数据实体的集合
    private final LinkedHashSet<Object> requestEntityList = new LinkedHashSet<>();

    public LinkedHashSet<Object> getRequestEntityList() {
        return requestEntityList;
    }

    public void addEntity(Object entity) {
        requestEntityList.add(entity);
    }

    public void cleanEntitys() {
        requestEntityList.clear();
    }

    private boolean contains(Object entity) {
        return requestEntityList.contains(entity);
    }

    /**
     * @param clazz Class
     * @return Object || null
     */
    private Object getEntityByType(Class clazz) {
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
        return "RequestEntities{" +
                "requestEntityList=" + requestEntityList +
                '}';
    }
}
