package org.hystudio.httpframework.framework2.processors2;

import org.hystudio.httpframework.framework2.data.DataBody;
import org.hystudio.httpframework.framework2.data.Header;
import org.hystudio.httpframework.utils.ObjectUtil;
import org.hystudio.httpframework.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class DefaultRequestProcessor implements IRequestHeaderProcessor, IRequestBodyProcessor {
    private Object[] requestEntities;
    private Object[] requestHeaders;
    private ProcessData processData;
    private DataBody dataBody;
    private Header header;

    @Override
    public void setRequestEntities(Object[] requestEntities) {
        this.requestEntities = requestEntities;
    }

    @Override
    public void setDataBody(DataBody dataBody) {
        this.dataBody = dataBody;
    }

    @Override
    public void setRequestHeaders(Object[] requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    @Override
    public void setHeader(Header header) {
        this.header = header;
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

    @Override
    public void setProcessData(ProcessData processData) {
        this.processData = processData;
    }

    @Override
    public void saveProcessData() {

    }
}
