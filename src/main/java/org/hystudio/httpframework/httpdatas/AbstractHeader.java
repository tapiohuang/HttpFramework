package org.hystudio.httpframework.httpdatas;

import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractHeader {
    private final TreeMap<String, String> headerMap;

    AbstractHeader() {
        this.headerMap = new TreeMap<>();
    }

    public void add(String key, String value, boolean cover) {
        if (cover) {
            headerMap.put(key, value);
        } else {
            String v = headerMap.get(key);
            if (v == null || v.length() == 0) {
                this.add(key, value, true);
                return;
            }
            String valueBuilder = v + ";" + value;
            headerMap.put(key, valueBuilder);
        }
    }

    public void add(String key, String value) {
        this.add(key, value, false);
    }

    public void add(Map<String, String> map, boolean cover) {
        map.forEach((k, v) -> {
            this.add(k, v, cover);
        });
    }

    public void add(Map<String, String> map) {
        this.add(map, false);
    }

    @Override
    public String toString() {
        return "AbstractHeader{" +
                "headerMap=" + headerMap +
                '}';
    }
}
