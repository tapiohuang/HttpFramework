package org.hystudio.httpframework.framework.data.response;

import java.util.Arrays;

public class ResponseBody {
    private byte[] responseBodyByteArray;

    public void set(String s) {
        responseBodyByteArray = s.getBytes();
    }

    public void set(byte[] bytes) {
        responseBodyByteArray = bytes;
    }

    public String readToString() {
        return new String(responseBodyByteArray);
    }

    public byte[] readToBytes() {
        return responseBodyByteArray;
    }

    @Override
    public String toString() {
        return "ResponseBody{" +
                "responseBodyByteArray=" + Arrays.toString(responseBodyByteArray) +
                '}';
    }
}
