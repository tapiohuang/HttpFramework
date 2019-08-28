package org.hystudio.httpframework.framework.parser.content;

import org.hystudio.httpframework.utils.StringUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class AbstractContentParser {
    protected LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();

    protected void readRequestEntity(Object o) {
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
                    String value = StringUtil.toString(method.invoke(o));
                    dataMap.put(fieldName, value);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
