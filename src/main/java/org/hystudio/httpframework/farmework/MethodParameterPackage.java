package org.hystudio.httpframework.farmework;

import org.hystudio.httpframework.utils.ObjectUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class MethodParameterPackage {
    private final MethodParameterBean methodParameterBean;
    private final HashMap<String, Object[]> requestDataKeyMap;
    private final LinkedList<Object> requestDataObjectList;
    private final HashMap<String, Object[]> requestHeaderKeyMap;
    private final LinkedList<Object> requestHeaderObjectList;
    private int requestDataObjectListSize = 0;
    private int requestHeaderObjectListSize = 0;

    public MethodParameterPackage() {
        methodParameterBean = new MethodParameterBean();
        requestDataKeyMap = new HashMap<>();
        requestHeaderKeyMap = new HashMap<>();
        requestDataObjectList = new LinkedList<>();
        requestHeaderObjectList = new LinkedList<>();
    }

    public void addDataKey(String key, Method method, Object object) {
        int index = requestDataObjectList.indexOf(object);
        if (index == -1) {
            index = requestDataObjectListSize;
            requestDataObjectList.addLast(object);
            requestDataObjectListSize++;
        }
        requestDataKeyMap.put(key, new Object[]{
                index, method
        });
    }

    public void addHeaderKey(String key, Method method, Object object) {
        int index = requestHeaderObjectList.indexOf(object);
        if (index == -1) {
            index = requestHeaderObjectListSize;
            requestHeaderObjectList.addLast(object);
            requestHeaderObjectListSize++;
        }
        requestHeaderKeyMap.put(key, new Object[]{
                index, method
        });
    }

    public Object getData(String key) {
        return get(key, this.requestDataKeyMap, this.requestDataObjectList);
    }

    public Object getHeader(String key) {
        return get(key, this.requestHeaderKeyMap, this.requestHeaderObjectList);
    }

    private Object get(String key, HashMap<String, Object[]> map, LinkedList<Object> list) {
        Object[] objects = map.get(key);
        if (objects != null) {
            int index = (int) objects[0];
            Method method = (Method) objects[1];
            Object obj = list.get(index);
            if (obj instanceof Map) {
                return ((Map) obj).get(key);
            } else {
                return ObjectUtil.callMethod(method, obj);
            }
        }
        return null;
    }

    public MethodParameterBean getMethodParameterBean() {
        return methodParameterBean;
    }
}
