package org.hystudio.httpframework.framework.processor.response;

import org.hystudio.httpframework.framework.data.response.ResponseData;

public interface IResponseProcessor {
    public void process();

    public Object getResult();

}
