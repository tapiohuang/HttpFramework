package org.hystudio.httpframework.framework2.processor.response;


import org.hystudio.httpframework.framework2.data.ResponseData;
import org.hystudio.httpframework.framework2.processor.IProcessor;

interface IResponseProcessor extends IProcessor {

    public ResponseData getResponseData();

    public void setResponseData(ResponseData responseData);

}
