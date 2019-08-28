package org.hystudio.httpframework.framework.handle.request;

import org.hystudio.httpframework.framework.config.RequestContentType;
import org.hystudio.httpframework.framework.config.RequestMethod;
import org.hystudio.httpframework.framework.data.HttpRequestDefinition;
import org.hystudio.httpframework.framework.data.request.RequestData;
import org.hystudio.httpframework.framework.factory.DefaultContentParserFactory;
import org.hystudio.httpframework.framework.interfaces.ContentParser;


public abstract class RequestDataHandle extends RequestHeaderHandle implements RequestHandle {
    private RequestData requestData;

    private HttpRequestDefinition httpRequestDefinition;

    public RequestDataHandle(HttpRequestDefinition httpRequestDefinition) {
        super(httpRequestDefinition);
        this.httpRequestDefinition = httpRequestDefinition;
        this.requestData = httpRequestDefinition.getRequestData();
    }

    @Override
    public void handle() {
        super.handle();
        requestDataHandle();
    }

    public void requestDataHandle() {
        ContentParser contentParser = httpRequestDefinition.getContentParser();
        if (contentParser == null) {
            contentParser = DefaultContentParserFactory.createParser(httpRequestDefinition.getRequestContentType());
            if (httpRequestDefinition.getRequestMethod().equals(RequestMethod.GET)) {
                contentParser = DefaultContentParserFactory.createParser(RequestContentType.FORM);
            }
        }
        contentParser.setRequestEntities(this.httpRequestDefinition.getRequestEntities());
        contentParser.setRequestBody(this.httpRequestDefinition.getRequestData().getRequestBody());
        contentParser.parser();
    }
}
