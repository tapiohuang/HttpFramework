package org.hystudio.httpframework.framework.data;

public class DataBody {
    private byte[] requestBodyByteArray;

    public DataBody(byte[] requestBodyByteArray) {
        this.requestBodyByteArray = requestBodyByteArray;
    }

    public DataBody(String s) {
        this.requestBodyByteArray = s.getBytes();
    }

    public DataBody() {
    }

    public void set(String s) {
        requestBodyByteArray = s.getBytes();
    }

    public void set(byte[] bytes) {
        requestBodyByteArray = bytes;
    }

    public String readToString() {
        return new String(requestBodyByteArray);
    }

    public byte[] readToBytes() {
        return requestBodyByteArray;
    }

}
