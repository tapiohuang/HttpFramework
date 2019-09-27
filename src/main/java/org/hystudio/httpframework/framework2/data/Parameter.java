package org.hystudio.httpframework.framework2.data;

import org.hystudio.httpframework.utils.StringUtil;

import java.util.Map;
import java.util.TreeMap;

public class Parameter {
    private final TreeMap<String, String> parameterMap = new TreeMap<>();

    public TreeMap<String, String> getParameterMap() {
        return parameterMap;
    }

    public void add(String key, String value, boolean cover) {
        if (cover) {
            parameterMap.put(key, value);
        } else {
            String v = parameterMap.get(key);
            if (v == null) {
                v = "";
            }
            StringBuilder valueBuilder = new StringBuilder(v);
            if (valueBuilder.length() != 0) {
                valueBuilder.append(";");
            }
            valueBuilder.append(value);
            parameterMap.put(key, valueBuilder.toString());
        }
    }

    public void add(String key, String value) {
        this.add(key, value, false);
    }

    public void addAll(Map map, boolean cover) {
        if (cover) {
            map.forEach((k, v) -> {
                parameterMap.put(StringUtil.toString(k), StringUtil.toString(v));
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
        return "Parameter{" +
                "parameterMap=" + parameterMap +
                '}';
    }
}
