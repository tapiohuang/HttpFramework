package org.hystudio.httpframework.framework2.data;

import java.util.Map;
import java.util.TreeMap;

public class Header {
    private final TreeMap<String, String> headerMap = new TreeMap<>();

    public TreeMap<String, String> getHeaderMap() {
        return headerMap;
    }

    public void add(String key, String value, boolean cover) {
        if (cover) {
            headerMap.put(key, value);
        } else {
            StringBuilder valueBuilder = new StringBuilder(headerMap.get(key));
            if (valueBuilder.length() != 0) {
                valueBuilder.append(";");
            }
            valueBuilder.append(value);
            headerMap.put(key, valueBuilder.toString());
        }
    }

    public void add(String key, String value) {
        this.add(key, value, false);
    }

    public void addAll(Map<String, String> map, boolean cover) {
        if (cover) {
            headerMap.putAll(map);
        } else {
            while (map.entrySet().iterator().hasNext()) {
                Map.Entry<String, String> entry = map.entrySet().iterator().next();
                this.add(entry.getKey(), entry.getValue());
            }
        }
    }

    public void addAll(Map<String, String> map) {
        this.addAll(map, false);
    }
}
