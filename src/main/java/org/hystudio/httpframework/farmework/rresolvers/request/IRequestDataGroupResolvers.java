package org.hystudio.httpframework.farmework.rresolvers.request;

import org.hystudio.httpframework.farmework.IRequestDataResolver;

public interface IRequestDataGroupResolvers extends IRequestDataResolver {
    public void addRequestDataResolver(IRequestDataResolver requestDataResolver);

    public void flush();
}
