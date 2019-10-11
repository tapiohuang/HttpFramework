package org.hystudio.httpframework.framework2.data;

public class ResponseData {
    private String Version;
    private int Status;
    private String Msg;
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


    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "Version='" + Version + '\'' +
                ", Status=" + Status +
                ", Msg='" + Msg + '\'' +
                ", header=" + header +
                ", dataBody=" + dataBody +
                '}';
    }
}
