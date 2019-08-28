package org.hystudio.httpframework.framework.interfaces;


import org.hystudio.httpframework.framework.data.request.RequestBody;
import org.hystudio.httpframework.framework.data.request.RequestEntities;

public interface ContentParser {
    public void parser();

    public void setRequestEntities(RequestEntities requestEntities);

    public void setRequestBody(RequestBody requestBody);
    //
}
