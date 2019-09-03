package org.hystudio.httpframework.framework.handle.request;


import org.hystudio.httpframework.framework.data.HttpHeader;
import org.hystudio.httpframework.framework.data.HttpRequestDefinition;
import org.hystudio.httpframework.framework.data.request.RequestHeaders;
import org.hystudio.httpframework.framework.interfaces.HttpHandle;
import org.hystudio.httpframework.utils.StringUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public abstract class RequestHeaderHandle implements HttpHandle {
    private RequestHeaders requestHeaders;

    private HttpHeader httpHeader;

    protected RequestHeaderHandle(HttpRequestDefinition httpRequestDefinition) {
        this.requestHeaders = httpRequestDefinition.getRequestHeaders();
        this.httpHeader = new HttpHeader();
        httpRequestDefinition.getRequestData().setHttpHeader(httpHeader);
    }

    @Override
    public void handle() {
        LinkedHashSet<Object> headerObjectSet = requestHeaders.getRequestEntityList();
        headerObjectSet.forEach(v -> {
            if (v instanceof Map) {
                httpHeader.addAll((Map) v);
            } else {
                httpHeader.addAll(prepareHeader(v));
            }
        });
    }

    private Map<String, String> prepareHeader(Object o) {
        TreeMap<String, String> headerMap = new TreeMap<>();
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
                    //Object v = method.invoke(o);
                    String value = StringUtil.toString(method.invoke(o));
                    headerMap.put(fieldName, value);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return headerMap;
    }
}
