package org.hystudio.httpframework.framework;

import java.util.HashMap;

public class HttpSessionTemplateMap {
    private static HttpSessionTemplateMap ourHttpSessionTemplateMap = new HttpSessionTemplateMap();
    private final HashMap<String, HttpSessionTemplate> httpSessionTemplateHashMap;

    public HttpSessionTemplateMap() {
        this.httpSessionTemplateHashMap = new HashMap<>();
    }

    public static HttpSessionTemplateMap getInstance() {
        return ourHttpSessionTemplateMap;
    }

    public void addHttpSessionTemplate(String httpSessionTemplateName, HttpSessionTemplate httpSessionTemplate) {
        httpSessionTemplateHashMap.put(httpSessionTemplateName, httpSessionTemplate);
    }

    public HttpSessionTemplate getHttpSessionTemplate(String httpSessionTemplateName) {
        return httpSessionTemplateHashMap.get(httpSessionTemplateName);
    }
}
