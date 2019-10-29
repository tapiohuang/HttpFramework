package org.hystudio.httpframework.processors;


import org.hystudio.httpframework.httpdatas.RequestHeader;

import java.util.LinkedList;

public interface IRequestHeaderProcessor extends IRequestProcessor {
    public void setRequestHeaderObjectList(LinkedList<Object> requestHeaderObjectList);

    public void setRequestHeader(RequestHeader requestHeader);
}
