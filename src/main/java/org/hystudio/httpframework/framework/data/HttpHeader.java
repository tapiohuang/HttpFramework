package org.hystudio.httpframework.framework.data;

import org.hystudio.httpframework.framework.exception.HttpRequestException;
import org.hystudio.httpframework.utils.StringUtil;

import java.util.Map;
import java.util.TreeMap;

public class HttpHeader {
    private final TreeMap<String, String> headerMap = new TreeMap<>();

    @Override
    public String toString() {
        return "HttpHeader{" +
                "headerMap=" + headerMap +
                '}';
    }

    public TreeMap<String, String> getHeaderMap() {
        return headerMap;
    }

    public void addAll(Map map) {
        map.forEach((k, v) -> {
            headerMap.put(StringUtil.toString(k), StringUtil.toString(v));
        });

    }

    public void add(String key, String value) {
        headerMap.put(key, value);
    }

    public String get(String key) {
        return headerMap.get(key);
    }

}
