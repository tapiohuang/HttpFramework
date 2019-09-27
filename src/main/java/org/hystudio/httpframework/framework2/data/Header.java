package org.hystudio.httpframework.framework2.data;

import org.hystudio.httpframework.utils.StringUtil;

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
            String v = headerMap.get(key);
            if (v == null) {
                v = "";
            }
            StringBuilder valueBuilder = new StringBuilder(v);
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

    public void addAll(Map map, boolean cover) {
        if (cover) {
            map.forEach((k, v) -> {
                headerMap.put(StringUtil.toString(k), StringUtil.toString(v));
            });
        } else {
            map.forEach((k, v) -> {
                this.add(StringUtil.toString(k), StringUtil.toString(v));
            });
        }
    }

    public void addAll(Map map) {
        this.addAll(map, false);
    }

    @Override
    public String toString() {
        return "Header{" +
                "headerMap=" + headerMap +
                '}';
    }
}
