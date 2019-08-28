package org.hystudio.httpframework.framework.data.request;

import java.util.Arrays;

public class RequestBody {
    private byte[] requestBodyByteArray;

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

    @Override
    public String toString() {
        return "HttpRequestBody{" +
                "requestBodyByteArray=" + Arrays.toString(requestBodyByteArray) +
                '}';
    }
}
