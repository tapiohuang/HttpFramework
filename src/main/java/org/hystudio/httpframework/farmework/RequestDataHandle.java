package org.hystudio.httpframework.farmework;


import org.hystudio.httpframework.HTTPSession;
import org.hystudio.httpframework.farmework.rresolvers.request.DefaultRequestDataGroupResolversFactory;

import java.util.LinkedList;

public class RequestDataHandle implements IHandle {
    private final HTTPSession httpSession;
    private final RequestData requestData;
    private final RequestDataManagerResolver requestDataManagerResolver;

    RequestDataHandle(HTTPSession httpSession) {
        this.httpSession = httpSession;
        this.requestData = new RequestData();
        this.requestDataManagerResolver = new RequestDataManagerResolver();
    }

    @Override
    public void handle() {
        this.preRequestResolverList();
        this.requestDataManagerResolver.setHTTPSession(this.httpSession);
        this.requestDataManagerResolver.setMethodParameterPackage(this.httpSession.getMethodParameterPackage());
        this.requestDataManagerResolver.setMethodParameterBean(this.httpSession.getMethodParameterBean());
        this.requestDataManagerResolver.setRequestData(this.requestData);
        this.requestDataManagerResolver.setRequestResolverList(this.httpSession.getMethodParameterBean().getRequestResolverList());
        this.requestDataManagerResolver.initialize();
        this.requestDataManagerResolver.resolver();
        this.setRequestDataToHTTPSession();
    }

    private void preRequestResolverList() {
        LinkedList<IRequestDataResolver> requestDataResolvers = this.httpSession.getMethodParameterBean().getRequestResolverList();
        if (requestDataResolvers.size() == 0) {
            requestDataResolvers.add(DefaultRequestDataGroupResolversFactory.produce(this.httpSession.getHttpContentType()));
        }
    }

    private void setRequestDataToHTTPSession() {
        this.httpSession.setRequestData(this.requestData);
    }
}
