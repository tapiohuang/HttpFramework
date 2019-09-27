package org.hystudio.httpframework.framework2.processor.request;


import org.hystudio.httpframework.framework2.data.Header;
import org.hystudio.httpframework.utils.ObjectUtil;
import org.hystudio.httpframework.utils.StringUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DefaultRequestHeaderProcessor extends AbstractRequestHeaderProcessor {
    private Header header;
    private Object[] requestEntities;
    private Object[] requestHeaders;

    @Override
    public void process() {
        for (Object object : requestHeaders
        ) {
            if (object instanceof Map) {
                header.addAll((Map) object);
            } else {
                HashMap<String, Object> map = ObjectUtil.readObjectAttributes(object);
                map.forEach((k, v) -> {
                    header.add(k, StringUtil.toString(v));
                });
            }
        }
    }

    @Override
    public void setHeader(Header header) {
        this.header = header;
    }

    @Override
    public void setRequestEntities(Object[] requestEntities) {
        this.requestEntities = requestEntities;
    }

    @Override
    public void setRequestHeaders(Object[] requestHeaders) {
        this.requestHeaders = requestHeaders;
    }
}
