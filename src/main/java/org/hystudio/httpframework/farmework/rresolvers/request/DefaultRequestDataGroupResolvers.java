package org.hystudio.httpframework.farmework.rresolvers.request;

import org.hystudio.httpframework.HTTPSession;
import org.hystudio.httpframework.farmework.IRequestDataResolver;
import org.hystudio.httpframework.farmework.MethodParameterBean;
import org.hystudio.httpframework.farmework.MethodParameterPackage;
import org.hystudio.httpframework.farmework.RequestData;

import java.util.LinkedList;

public class DefaultRequestDataGroupResolvers extends AbstractDefaultRequestDataResolver
        implements IRequestDataGroupResolvers {
    private final LinkedList<IRequestDataResolver> requestDataResolvers;
    private RequestData requestData;
    private HTTPSession httpSession;
    private MethodParameterPackage methodParameterPackage;
    private MethodParameterBean methodParameterBean;

    public DefaultRequestDataGroupResolvers() {
        requestDataResolvers = new LinkedList<>();
    }

    @Override
    public void resolver() {
        this.flush();
        for (IRequestDataResolver requestDataResolver : requestDataResolvers
        ) {
            requestDataResolver.resolver();
        }
    }

    @Override
    public void addRequestDataResolver(IRequestDataResolver requestDataResolver) {
        requestDataResolvers.addLast(requestDataResolver);
    }

    @Override
    public void flush() {
        for (IRequestDataResolver requestDataResolver : requestDataResolvers
        ) {
            requestDataResolver.setMethodParameterPackage(methodParameterPackage);
            requestDataResolver.setMethodParameterBean(methodParameterBean);
            requestDataResolver.setHTTPSession(httpSession);
            requestDataResolver.setRequestData(requestData);
        }
    }
}
