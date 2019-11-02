package org.hystudio.httpframework.farmework;

import org.hystudio.httpframework.HTTPSession;
import org.hystudio.httpframework.annonations.ResolverOrder;

import java.util.HashMap;
import java.util.LinkedList;

public class RequestDataManagerResolver implements IResolver, IRequestDataResolver {
    private LinkedList<IRequestDataResolver> requestResolverList;
    private HTTPSession httpSession;
    private MethodParameterPackage methodParameterPackage;
    private MethodParameterBean methodParameterBean;
    private RequestData requestData;


    public void initialize() {
        this.orderRequestResolverList();
        for (IRequestDataResolver requestDataResolver : requestResolverList
        ) {
            requestDataResolver.setRequestData(requestData);
            requestDataResolver.setHTTPSession(httpSession);
            requestDataResolver.setMethodParameterBean(methodParameterBean);
            requestDataResolver.setMethodParameterPackage(methodParameterPackage);
        }
    }

    private void orderRequestResolverList() {
        LinkedList<IRequestDataResolver> tmpRequestDataResolverList;
        LinkedList<IRequestDataResolver> unOrderRequestDataResolverList = new LinkedList<>();
        HashMap<Integer, LinkedList<IRequestDataResolver>> requestDataResolversInOrderMap = new HashMap<>();
        for (IRequestDataResolver requestDataResolver : requestResolverList
        ) {
            ResolverOrder resolverOrder = requestDataResolver.getClass().getAnnotation(ResolverOrder.class);
            if (resolverOrder == null) {
                unOrderRequestDataResolverList.addLast(requestDataResolver);
            } else {
                int index = resolverOrder.value();
                tmpRequestDataResolverList = requestDataResolversInOrderMap.get(index);
                if (tmpRequestDataResolverList == null) {
                    tmpRequestDataResolverList = new LinkedList<>();
                }
                tmpRequestDataResolverList.addLast(requestDataResolver);
                requestDataResolversInOrderMap.put(index, tmpRequestDataResolverList);
            }
        }
        requestResolverList.clear();
        requestDataResolversInOrderMap.forEach((k, v) -> {
            requestResolverList.addAll(v);
        });
        requestResolverList.addAll(unOrderRequestDataResolverList);
    }

    @Override
    public void resolver() {
        for (IRequestDataResolver requestDataResolver : requestResolverList
        ) {
            requestDataResolver.resolver();
        }
    }

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

    public void setRequestResolverList(LinkedList<IRequestDataResolver> requestResolverList) {
        this.requestResolverList = requestResolverList;
    }
}
