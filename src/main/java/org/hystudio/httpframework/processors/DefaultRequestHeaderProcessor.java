package org.hystudio.httpframework.processors;


import com.google.gson.internal.LinkedTreeMap;
import org.hystudio.httpframework.httpdatas.RequestHeader;
import org.hystudio.httpframework.utils.ObjectUtil;
import org.hystudio.httpframework.utils.StringUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DefaultRequestHeaderProcessor extends AbstractProcessor implements IRequestHeaderProcessor {
    private LinkedList<Object> requestHeaderObjectList;
    private ProcessData processData;
    private RequestHeader requestHeader;


    @Override
    public void process() {
        this.parserHeader();
    }

    private void parserHeader() {
        if (requestHeaderObjectList == null) {
            throw new RuntimeException("requestHeaderObjectList iS Null!");
        }
        for (Object object : requestHeaderObjectList
        ) {
            if (object instanceof Map) {
                requestHeader.add(this.traverseMap((Map) object));
            } else {
                HashMap<String, Object> map = ObjectUtil.readObjectAttributes(object);
                map.forEach((k, v) -> {
                    requestHeader.add(k, StringUtil.toString(v));
                });
            }
        }
    }

    private LinkedTreeMap<String, String> traverseMap(Map map) {
        LinkedTreeMap<String, String> treeMap = new LinkedTreeMap<>();
        map.forEach((k, v) -> {
            treeMap.put(StringUtil.toString(k), StringUtil.toString(v));
        });
        return treeMap;
    }

    @Override
    public void setRequestHeaderObjectList(LinkedList<Object> requestHeaderObjectList) {
        this.requestHeaderObjectList = requestHeaderObjectList;
    }

    @Override
    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    @Override
    public void saveProcessData() {

    }
}
