package org.hystudio.httpframework.framework.handle;


import org.hystudio.httpframework.framework.data.HttpRequestDefinition;
import org.hystudio.httpframework.framework.handle.request.RequestSenderHandle;
import org.hystudio.httpframework.framework.handle.response.ResponseReaderHandle;


import java.io.IOException;
import java.lang.reflect.Method;

public class RequestHandle {
    private HttpRequestDefinition httpRequestDefinition;
    private RequestSenderHandle requestSenderHandle;
    private ResponseReaderHandle responseReaderHandle;
    private HttpRequestDefinitionProvider httpRequestDefinitionProvider;
    private Method method;
    private Object[] args;

    public RequestHandle(Method method, Object[] args) {
        this.method = method;
        this.args = args;
        this.httpRequestDefinitionProvider = new HttpRequestDefinitionProvider();
    }

    public Object handle() throws IOException {
        httpRequestDefinition = httpRequestDefinitionProvider.provide(method, args);
        requestSenderHandle = new RequestSenderHandle(httpRequestDefinition);
        responseReaderHandle = new ResponseReaderHandle(httpRequestDefinition);
        requestSenderHandle.handle();
        responseReaderHandle.handle();
        return null;
    }

}