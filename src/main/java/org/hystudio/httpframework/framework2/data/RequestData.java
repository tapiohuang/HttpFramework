package org.hystudio.httpframework.framework2.data;

public class RequestData {
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
}
