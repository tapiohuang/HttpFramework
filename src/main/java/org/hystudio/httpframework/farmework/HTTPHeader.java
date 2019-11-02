package org.hystudio.httpframework.farmework;

import com.google.gson.internal.LinkedTreeMap;

import java.util.LinkedHashSet;

public class HTTPHeader {
    private final LinkedTreeMap<String, LinkedHashSet<String>> headerSetMap;
    private final LinkedTreeMap<String, String> headerMap;

    public HTTPHeader() {
        headerSetMap = new LinkedTreeMap<>();
        headerMap = new LinkedTreeMap<>();
    }

    public void add(String key, String value) {
        LinkedHashSet<String> valueSet = headerSetMap.get(key);
        if (valueSet == null) {
            valueSet = new LinkedHashSet<>();
        }
        valueSet.add(value);
    }

    public void remove(String key, String value) {
        LinkedHashSet<String> valueSet = headerSetMap.get(key);
        if (valueSet != null) {
            valueSet.remove(value);
        }
    }

    public void remove(String key) {
        headerSetMap.remove(key);
    }

    public void flushHeader() {
        headerMap.clear();
        headerSetMap.forEach((k, v) -> {
            StringBuilder valueStringBuilder = new StringBuilder();
            int index = 0;
            for (String value : v
            ) {
                valueStringBuilder.append(value);
                if (index > 0 && index == (v.size() - 1)) {
                    valueStringBuilder.append(";");
                }
                index++;
                headerMap.put(k, valueStringBuilder.toString());
            }
        });
    }
}
