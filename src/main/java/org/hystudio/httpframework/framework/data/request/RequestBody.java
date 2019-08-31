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

    public void add(byte[] bytes) {
        synchronized (this) {
            byte[] newArray = new byte[requestBodyByteArray.length + bytes.length];
            int index = 0;
            for (byte b : requestBodyByteArray
            ) {
                newArray[index] = b;
                index++;
            }
            for (byte b : bytes
            ) {
                newArray[index] = b;
                index++;
            }
            requestBodyByteArray = newArray;
        }

    }

    @Override
    public String toString() {
        return "HttpRequestBody{" +
                "requestBodyByteArray=" + Arrays.toString(requestBodyByteArray) +
                '}';
    }
}
