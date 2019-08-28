package org.hystudio.httpframework.framework.parser.content;

import org.hystudio.httpframework.framework.data.request.RequestBody;
import org.hystudio.httpframework.framework.data.request.RequestEntities;
import org.hystudio.httpframework.framework.interfaces.ContentParser;
import org.hystudio.httpframework.utils.GsonUtil;
import org.hystudio.httpframework.utils.StringUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class DefaultJsonContentParser implements ContentParser {
    private RequestEntities requestEntities;
    private LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
    private RequestBody requestBody;

    @Override
    public void parser() {
        LinkedHashSet<Object> requestEntityList = requestEntities.getRequestEntityList();
        requestEntityList.forEach(this::readRequestEntity);
        requestBody.set(GsonUtil.toJson(dataMap));
    }

    @Override
    public void setRequestEntities(RequestEntities requestEntities) {
        this.requestEntities = requestEntities;
    }

    @Override
    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    private void readRequestEntity(Object o) {
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
