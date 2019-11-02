package org.hystudio.httpframework.farmework;

import org.hystudio.httpframework.HTTPSession;

public interface IResolver {
    public void resolver();

    public void setHTTPSession(HTTPSession httpSession);

    public void setMethodParameterPackage(MethodParameterPackage methodParameterPackage);

    public void setMethodParameterBean(MethodParameterBean methodParameterBean);
}
