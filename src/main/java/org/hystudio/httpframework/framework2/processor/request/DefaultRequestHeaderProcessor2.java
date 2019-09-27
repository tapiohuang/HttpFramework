package org.hystudio.httpframework.framework2.processor.request;

import org.hystudio.httpframework.framework2.data.Header;
import org.hystudio.httpframework.utils.ObjectUtil;
import org.hystudio.httpframework.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class DefaultRequestHeaderProcessor2 implements IRequestHeaderProcess {
    private Header header;
    private Object[] requestHeaders;

    @Override
    public void setRequestHeaders(Object[] requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

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
}
