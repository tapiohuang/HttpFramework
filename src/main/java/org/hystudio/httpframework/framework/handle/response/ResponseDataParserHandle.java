package org.hystudio.httpframework.framework.handle.response;

import org.hystudio.httpframework.framework.data.HttpRequestDefinition;
import org.hystudio.httpframework.framework.exception.HttpRequestException;
import org.hystudio.httpframework.framework.exception.HttpSessionExecuteException;
import org.hystudio.httpframework.framework.interfaces.DataParser;

public abstract class ResponseDataParserHandle extends ResponseDataHandle {
    private HttpRequestDefinition httpRequestDefinition;

    public ResponseDataParserHandle(HttpRequestDefinition httpRequestDefinition) {
        super(httpRequestDefinition);
        this.httpRequestDefinition = httpRequestDefinition;
    }

    @Override
    public void handle() throws HttpSessionExecuteException {
        super.handle();
        parserData();
    }

    private void parserData() {
        DataParser dataParser = httpRequestDefinition.getDataParser();
        if (dataParser == null) {
            throw new HttpRequestException("返回报文解析器为NULL");
        }
        dataParser.setResponseData(httpRequestDefinition.getResponseData());
        dataParser.setResponseType(httpRequestDefinition.getResponseType());
        Object result = dataParser.parser();
        httpRequestDefinition.setResponseObject(result);
    }
}
