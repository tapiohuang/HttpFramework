package org.hystudio.httpframework.resolvers;

import org.hystudio.httpframework.beans.RequestEntityObjectBean;
import org.hystudio.httpframework.httpdatas.RequestData;

import java.util.LinkedList;

public interface IRequestDataResolver {
    public void setRequestData(RequestData requestData);

    public void setRequestEntityObjectList(LinkedList<Object> requestEntityObjectList);

    public void setRequestHeaderObjectList(LinkedList<Object> requestHeaderObjectList);

    public void setRequestEntityObjectBean(RequestEntityObjectBean requestEntityObjectBean);

}
