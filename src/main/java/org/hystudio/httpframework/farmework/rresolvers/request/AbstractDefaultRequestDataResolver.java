package org.hystudio.httpframework.farmework.rresolvers.request;

import org.hystudio.httpframework.HTTPSession;
import org.hystudio.httpframework.farmework.IRequestDataResolver;
import org.hystudio.httpframework.farmework.MethodParameterBean;
import org.hystudio.httpframework.farmework.MethodParameterPackage;
import org.hystudio.httpframework.farmework.RequestData;

public abstract class AbstractDefaultRequestDataResolver implements IRequestDataResolver {
    private RequestData requestData;
    private HTTPSession httpSession;
    private MethodParameterPackage methodParameterPackage;
    private MethodParameterBean methodParameterBean;

    @Override
    public abstract void resolver();

    @Override
    public void setHTTPSession(HTTPSession httpSession) {
        this.httpSession = httpSession;
    }

    @Override
    public void setMethodParameterPackage(MethodParameterPackage methodParameterPackage) {
        this.methodParameterPackage = methodParameterPackage;
    }

    @Override
    public void setMethodParameterBean(MethodParameterBean methodParameterBean) {
        this.methodParameterBean = methodParameterBean;
    }

    @Override
    public void setRequestData(RequestData requestData) {
        this.requestData = requestData;
    }
}
