package org.hystudio.httpframework.framework.interfaces;

import org.hystudio.httpframework.framework.data.response.ResponseData;

public interface DataParser {
    public Object parser();

    public void setResponseData(ResponseData responseData);
}
