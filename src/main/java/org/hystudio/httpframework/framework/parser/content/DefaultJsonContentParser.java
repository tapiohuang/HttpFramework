package org.hystudio.httpframework.framework.parser.content;

import org.hystudio.httpframework.framework.data.request.RequestBody;
import org.hystudio.httpframework.framework.data.request.RequestEntities;
import org.hystudio.httpframework.framework.interfaces.ContentParser;
import org.hystudio.httpframework.utils.GsonUtil;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class DefaultJsonContentParser extends AbstractContentParser implements ContentParser {
    private RequestEntities requestEntities;
    private RequestBody requestBody;

    @Override
    public void parser() {
        LinkedHashSet<Object> requestEntityList = requestEntities.getRequestEntityList();
        requestEntityList.forEach(this::readRequestEntity);
        requestBody.set(GsonUtil.toJson(dataMap));
    }

    @Override
    public void setRequestEntities(RequestEntities requestEntities) {
        this.requestEntities = requestEntities;
    }

    @Override
    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

}
