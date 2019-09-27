package org.hystudio.httpframework.framework2.data;

import java.util.Arrays;

public class DataBody {
    private byte[] bodyByteArray;

    public void set(String s) {
        bodyByteArray = s.getBytes();
    }

    public void set(byte[] bytes) {
        bodyByteArray = bytes;
    }

    public String readToString() {
        return new String(bodyByteArray);
    }

    public byte[] readToBytes() {
        return bodyByteArray;
    }

    public void add(byte[] bytes) {
        synchronized (this) {
            byte[] newArray = new byte[bodyByteArray.length + bytes.length];
            int index = 0;
            for (byte b : bodyByteArray
            ) {
                newArray[index] = b;
                index++;
            }
            for (byte b : bytes
            ) {
                newArray[index] = b;
                index++;
            }
            bodyByteArray = newArray;
        }

    }

    @Override
    public String toString() {
        return "DataBody{" +
                "bodyByteArray=" + Arrays.toString(bodyByteArray) +
                '}';
    }
}
