package org.hystudio.httpframework.framework2.data;

import org.hystudio.httpframework.framework2.config.RequestMethod;

public class RequestData {
    private RequestMethod requestMethod;
    private String URL;
    private String Version;
    private Header header;
    private DataBody dataBody;
    private Parameter parameter;

    public RequestData() {
        this.header = new Header();
        this.dataBody = new DataBody();
        this.parameter = new Parameter();
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public DataBody getDataBody() {
        return dataBody;
    }

    public void setDataBody(DataBody dataBody) {
        this.dataBody = dataBody;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "header=" + header +
                ", dataBody=" + dataBody +
                ", parameter=" + parameter +
                '}';
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }
}
