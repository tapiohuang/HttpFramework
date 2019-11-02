package org.hystudio.httpframework.farmework.rresolvers.request;

import org.hystudio.httpframework.annonations.ResolverOrder;
import org.hystudio.httpframework.farmework.IRequestDataResolver;

@ResolverOrder(3)
public class DefaultRequestDataHeaderPostResolver extends AbstractDefaultRequestDataResolver
        implements IRequestDataResolver, IRequestDataHeaderResolver {

    @Override
    public void resolver() {

    }
}
