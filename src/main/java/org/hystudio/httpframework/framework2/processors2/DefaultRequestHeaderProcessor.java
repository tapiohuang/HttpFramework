package org.hystudio.httpframework.framework2.processors2;

import org.hystudio.httpframework.framework2.data.DataBody;
import org.hystudio.httpframework.framework2.data.Header;
import org.hystudio.httpframework.utils.ObjectUtil;
import org.hystudio.httpframework.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class DefaultRequestHeaderProcessor implements IRequestHeaderProcessor {
    private Object[] requestHeaders;
    private ProcessData processData;
    private Header header;


    @Override
    public void setRequestHeaders(Object[] requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    @Override
    public void setHeader(Header header) {
        this.header = header;
    }

    @Override
    public void setProcessData(ProcessData processData) {
        this.processData = processData;
    }

    @Override
    public void saveProcessData() {

    }

    @Override
    public void process() {
        this.parserHeader();
    }

    private void parserHeader() {
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
