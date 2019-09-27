package org.hystudio.httpframework.framework2.processor.request;

import org.hystudio.httpframework.framework2.data.DataBody;
import org.hystudio.httpframework.framework2.data.RequestData;

public abstract class AbstractRequestBodyProcessor extends AbstractRequestProcessor {
    public abstract void setDataBody(DataBody dataBody);

    //@Override
    public void setRequestData(RequestData requestData) {
        //super.setRequestData(requestData);
        this.setDataBody(requestData.getDataBody());
    }

    public abstract void setRequestEntities(Object[] requestEntities);

    public abstract void setRequestHeaders(Object[] requestHeaders);
}
