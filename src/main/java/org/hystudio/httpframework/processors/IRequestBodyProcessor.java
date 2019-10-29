package org.hystudio.httpframework.processors;


import org.hystudio.httpframework.httpdatas.RequestBody;

import java.util.LinkedList;

public interface IRequestBodyProcessor extends IRequestProcessor {
    public void setRequestEntityObjectList(LinkedList<Object> requestEntityObjectList);

    public void setRequestBody(RequestBody requestBody);
}
