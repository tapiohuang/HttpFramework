package org.hystudio.httpframework;


import org.hystudio.httpframework.resolvers.HttpResolver;
import org.hystudio.httpframework.resolvers.RequestDataResolver;
import org.hystudio.httpframework.resolvers.ResponseDataResolver;

public interface IRequestSession {
    public void setRequestMethod(RequestMethod requestMethod);

    public void setUrl(String url);

    public void setContentType(ContentType contentType);

    public void setDataType(DataType dataType);

    public void setResponseDataResolver(ResponseDataResolver responseDataResolver);

    public void setRequestDataResolver(RequestDataResolver requestDataResolver);

    public void setHttpResolver(HttpResolver httpResolver);

}
