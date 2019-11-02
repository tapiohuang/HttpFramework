package org.hystudio.httpframework.farmework.rresolvers.request;

import org.hystudio.httpframework.annonations.ResolverOrder;
import org.hystudio.httpframework.farmework.IRequestDataResolver;

@ResolverOrder(2)
public class DefaultRequestDataBodyResolver__JSON extends AbstractDefaultRequestDataResolver
        implements IRequestDataResolver, IRequestDataBodyResolver {

    @Override
    public void resolver() {

    }
}
