package org.hystudio.httpframework.utils;

import org.hystudio.httpframework.framework2.annotation.Except;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class ObjectUtil {
    public static HashMap<String, Object> readObjectAttributes(Object object) {
        HashMap<String, Object> attributes = new HashMap<>();
        HashMap<String, Method> methodHashMap = ClassUtil.getMethodMap(object);
        ArrayList<Field> attributeList = ClassUtil.getAttributeList(object, Except.class);
        attributeList.forEach(field -> {
            String fieldName = StringUtil.upperFirstWord(field.getName());
            String methodName = "get" + fieldName;
            Method method = methodHashMap.get(methodName);
            if (method != null) {
                Object value = ClassUtil.callMethod(method, object);
                boolean isBaseType = ClassUtil.isBaseType(value);
                if (isBaseType) {
                    attributes.put(fieldName, value);
                } else {
                    if (value instanceof Map) {
                        attributes.putAll((Map<? extends String, ?>) value);
                    } else if (value instanceof Collection) {
                        attributes.put(fieldName, value);
                    } else {
                        attributes.put(fieldName, readObjectAttributes(value));
                    }
                }
            }
        });
        return attributes;
    }
}
