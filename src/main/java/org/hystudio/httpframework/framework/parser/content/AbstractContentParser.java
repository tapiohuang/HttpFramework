package org.hystudio.httpframework.framework.parser.content;

import org.hystudio.httpframework.utils.StringUtil;
import org.hystudio.httpframework.utils.TypeUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class AbstractContentParser {
    protected LinkedHashMap<String, Object> dataMap = new LinkedHashMap<>();

    protected void readRequestEntity(Object o) {
        dataMap.putAll(deepReadRequestEntity(o));
    }

    protected LinkedHashMap<String, Object> deepReadRequestEntity(Object o) {
        LinkedHashMap<String, Object> tempMap = new LinkedHashMap<>();
        Field[] fields = o.getClass().getDeclaredFields();
        Method[] methods = o.getClass().getMethods();
        HashMap<String, Integer> methodNameMap = new HashMap<>();
        for (int i = 0; i < methods.length; i++) {
            methodNameMap.put(methods[i].getName(), i);
        }
        for (Field f : fields
        ) {
            String fieldName = f.getName();
            Integer index = methodNameMap.get("get" + StringUtil.upperFirstWord(fieldName));

            if (index != null) {
                Method method = methods[index];
                try {
                    Object value = method.invoke(o);
                    if (TypeUtil.isBaseType(value.getClass()) || value instanceof Collection) {
                        tempMap.put(fieldName, value);
                    } else {
                        tempMap.put(fieldName, deepReadRequestEntity(value));
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        //System.out.println(tempMap);
        return tempMap;
    }
}
