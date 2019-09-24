package org.hystudio.httpframework.framework2.data;

public class ResponseData {
    private Header header;
    private DataBody dataBody;

    public ResponseData() {
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
