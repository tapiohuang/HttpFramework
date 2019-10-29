package org.hystudio.httpframework.framework2.processors2;

import org.hystudio.httpframework.framework2.data.DataBody;
import org.hystudio.httpframework.framework2.data.Header;
import org.hystudio.httpframework.utils.ObjectUtil;
import org.hystudio.httpframework.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class DefaultRequestBodyProcessor implements IRequestBodyProcessor {
    private Object[] requestEntities;
    private ProcessData processData;
    private DataBody dataBody;

    @Override
    public void setRequestEntities(Object[] requestEntities) {
        this.requestEntities = requestEntities;
    }

    @Override
    public void setDataBody(DataBody dataBody) {
        this.dataBody = dataBody;
    }

    @Override
    public void process() {
        this.parserDataBody();
    }

    private void parserDataBody() {

    }

    @Override
    public void setProcessData(ProcessData processData) {
        this.processData = processData;
    }

    @Override
    public void saveProcessData() {

    }
}
