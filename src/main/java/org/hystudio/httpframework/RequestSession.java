package org.hystudio.httpframework;

import org.hystudio.httpframework.httpdatas.RequestData;
import org.hystudio.httpframework.httpdatas.ResponseData;
import org.hystudio.httpframework.resolvers.HttpResolver;
import org.hystudio.httpframework.resolvers.RequestDataResolver;
import org.hystudio.httpframework.resolvers.ResponseDataResolver;

public class RequestSession implements
        IRequestSession, IRequestResolvableSession {
    private RequestData requestData;
    private ResponseData responseData;
    private ResponseDataResolver responseDataResolver;
    private RequestDataResolver requestDataResolver;
    private HttpResolver httpResolver;
    private RequestMethod requestMethod;
    private String url;
    private ContentType contentType;
    private DataType dataType;

    private RequestSession() {
        requestData = new RequestData();
        responseData = new ResponseData();
    }

    static RequestSession createSession() {
        return new RequestSession();
    }

    public RequestData getRequestData() {
        return requestData;
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    @Override
    public void setResponseDataResolver(ResponseDataResolver responseResolver) {
        this.responseDataResolver = responseResolver;
    }

    @Override
    public void setRequestDataResolver(RequestDataResolver requestResolver) {
        this.requestDataResolver = requestResolver;
    }

    @Override
    public void setHttpResolver(HttpResolver httpResolver) {
        this.httpResolver = httpResolver;
    }

    @Override
    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    @Override
    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    @Override
    public void executeRequestDataResolver() {
        this.requestDataResolver.resolver();
        this.requestDataResolver.execute();
    }

    @Override
    public void executeResponseDataResolver() {
        //this.responseResolver.resolver();
    }
}
