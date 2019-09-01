package org.hystudio.httpframework.framework.parser.data;

import org.hystudio.httpframework.framework.data.response.ResponseData;
import org.hystudio.httpframework.framework.interfaces.DataParser;
import org.hystudio.httpframework.utils.GsonUtil;

public class DefaultJsonDataParser implements DataParser {
    private ResponseData responseData;
    private Class responseType;


    @Override
    public Object parser() {
        return GsonUtil.fromJson(responseData.getHttpResponseBody().readToString(), responseType);
    }

    @Override
    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    @Override
    public void setResponseType(Class responseType) {
        this.responseType = responseType;
    }
}
