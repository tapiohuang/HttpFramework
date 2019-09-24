package org.hystudio.httpframework.framework2.data;

public class RequestData {
    private Header header;
    private DataBody dataBody;

    public RequestData() {
        this.header = new Header();
        this.dataBody = new DataBody();
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
}
