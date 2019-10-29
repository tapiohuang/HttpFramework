package org.hystudio.httpframework.beans;

import org.hystudio.httpframework.utils.ObjectUtil;
import org.hystudio.httpframework.utils.StringUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public final class RequestEntityObjectBean {
    private final HashMap<String, Object[]> methodHashMap;
    private final ArrayList<Object> objectArrayList;

    public RequestEntityObjectBean() {
        methodHashMap = new HashMap<>();
        objectArrayList = new ArrayList<>();
    }

    public Object get(String attribute) {
        Object[] objects = methodHashMap.get("get" + StringUtil.upperFirstWord(attribute));
        if (objects != null) {
            Object object = objectArrayList.get((int) objects[0]);
            Method method = (Method) objects[1];
            Object o = ObjectUtil.callMethod(method, object);
            if (o != null) {
                return o;
            }
        }
        return null;
    }

    public void addMethod(Method method, Object object) {
        Object[] objects = new Object[2];
        int objectIndex = objectArrayList.indexOf(object);
        if (objectIndex == -1) {
            objectIndex = objectArrayList.size();
            objectArrayList.add(object);
        }
        objects[0] = objectIndex;
        objects[1] = method;
        methodHashMap.put(method.getName(), objects);
    }

    @Override
    public String toString() {
        return "RequestEntityObjectBean{" +
                "methodHashMap=" + methodHashMap +
                ", objectArrayList=" + objectArrayList +
                '}';
    }
}
