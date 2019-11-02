package org.hystudio.httpframework.farmework.rresolvers.request;

import org.hystudio.httpframework.type.HTTPContentType;
import org.hystudio.httpframework.type.HTTPRequestMethodType;

public interface IDefaultRequestDataResolverFactory {

    public void setHTTPRequestMethodType(HTTPRequestMethodType httpRequestMethodType);

    public void setHTTPContentType(HTTPContentType httpContentType);

}
