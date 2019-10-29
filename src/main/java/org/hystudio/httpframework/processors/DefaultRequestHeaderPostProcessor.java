package org.hystudio.httpframework.processors;

import org.hystudio.httpframework.httpdatas.RequestBody;
import org.hystudio.httpframework.httpdatas.RequestHeader;
import org.hystudio.httpframework.utils.StringUtil;

import java.util.LinkedList;

public class DefaultRequestHeaderPostProcessor extends AbstractProcessor implements IRequestHeaderProcessor {
    private ProcessData processData;
    private RequestHeader requestHeader;

    @Override
    public void setRequestHeaderObjectList(LinkedList<Object> requestHeaderObjectList) {
        
    }

    @Override
    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    @Override
    public void saveProcessData() {

    }

    @Override
    public void process() {
        RequestBody requestBody = this.requestHeader.getRequestData().getRequestBody();
        this.requestHeader.add("Content-Length", StringUtil.toString(requestBody.bodyLength()));
    }
}
