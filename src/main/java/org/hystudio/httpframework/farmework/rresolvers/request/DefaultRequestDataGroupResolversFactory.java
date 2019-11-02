package org.hystudio.httpframework.farmework.rresolvers.request;

import org.hystudio.httpframework.farmework.IRequestDataResolver;
import org.hystudio.httpframework.type.HTTPContentType;
import org.hystudio.httpframework.type.HTTPRequestMethodType;

public class DefaultRequestDataGroupResolversFactory implements IDefaultRequestDataResolverFactory {
    private HTTPRequestMethodType httpRequestMethodType;
    private HTTPContentType httpContentType;

    private DefaultRequestDataGroupResolversFactory() {
    }

    public static IRequestDataGroupResolvers produce(HTTPContentType httpContentType) {
        DefaultRequestDataGroupResolversFactory defaultRequestDataGroupResolversFactory = new DefaultRequestDataGroupResolversFactory();
        defaultRequestDataGroupResolversFactory.setHTTPContentType(httpContentType);
        return defaultRequestDataGroupResolversFactory.produce();
    }


    public DefaultRequestDataGroupResolvers produce() {
        DefaultRequestDataGroupResolvers defaultRequestDataGroupResolvers = new DefaultRequestDataGroupResolvers();
        if (this.httpContentType == HTTPContentType.JSON) {
            IRequestDataResolver requestDataResolver = new DefaultRequestDataBodyResolver__JSON();
            defaultRequestDataGroupResolvers.addRequestDataResolver(requestDataResolver);
        }
        return defaultRequestDataGroupResolvers;
    }

    @Override
    public void setHTTPRequestMethodType(HTTPRequestMethodType httpRequestMethodType) {
        this.httpRequestMethodType = httpRequestMethodType;
    }

    @Override
    public void setHTTPContentType(HTTPContentType httpContentType) {
        this.httpContentType = httpContentType;
    }
}
