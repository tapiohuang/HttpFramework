package org.hystudio.httpframework.processors;

import org.hystudio.httpframework.httpdatas.RequestBody;
import org.hystudio.httpframework.utils.LogUtils;

import java.util.LinkedList;

public class DefaultRequestBodyProcessor extends AbstractProcessor implements IRequestBodyProcessor {
    private LinkedList<Object> requestEntityObjectList;
    private RequestBody requestBody;


    @Override
    public void setRequestEntityObjectList(LinkedList<Object> requestEntityObjectList) {
        this.requestEntityObjectList = requestEntityObjectList;
    }

    @Override
    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    @Override
    public void process() {
        LogUtils.info("requestEntityObjectList",requestEntityObjectList);
    }

    @Override
    public void saveProcessData() {

    }
}
