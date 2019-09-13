package org.hystudio.httpframework.framework.parser.content;


import org.hystudio.httpframework.framework.data.request.RequestBody;
import org.hystudio.httpframework.framework.data.request.RequestEntities;
import org.hystudio.httpframework.framework.exception.HttpSessionExecuteException;
import org.hystudio.httpframework.framework.interfaces.ContentParser;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DefaultFormContentParser extends AbstractContentParser implements ContentParser {
    private RequestEntities requestEntities;
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
            try {
                requestDataStringBuilder.append(k).append("=").append(URLEncoder.encode((String) v, "utf-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                throw new HttpSessionExecuteException(e);
            }
        });
        requestDataStringBuilder.deleteCharAt(requestDataStringBuilder.length() - 1);
        requestBody.set(requestDataStringBuilder.toString());
    }

}
