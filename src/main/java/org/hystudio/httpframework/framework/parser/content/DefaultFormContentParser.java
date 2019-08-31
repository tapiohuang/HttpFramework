package org.hystudio.httpframework.framework.parser.content;


import org.hystudio.httpframework.framework.data.request.RequestBody;
import org.hystudio.httpframework.framework.data.request.RequestEntities;
import org.hystudio.httpframework.framework.interfaces.ContentParser;

import java.util.*;

public class DefaultFormContentParser extends AbstractContentParser implements ContentParser {
    private RequestEntities requestEntities;
    private LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
    private RequestBody requestBody;

    @Override
    public void parser() {
        LinkedHashSet<Object> requestEntityList = requestEntities.getRequestEntityList();
        requestEntityList.forEach(this::readRequestEntity);
        requestDataString();
    }

    @Override
    public void setRequestEntities(RequestEntities requestEntities) {
        this.requestEntities = requestEntities;
    }

    @Override
    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    private void requestDataString() {
        StringBuilder requestDataStringBuilder = new StringBuilder();
        dataMap.forEach((k, v) -> {
            requestDataStringBuilder.append(k).append("=").append(v).append("&");
        });
        requestDataStringBuilder.deleteCharAt(requestDataStringBuilder.length() - 1);
        requestBody.set(requestDataStringBuilder.toString());
    }
    

}
