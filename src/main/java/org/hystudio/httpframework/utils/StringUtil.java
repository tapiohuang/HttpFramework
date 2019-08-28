package org.hystudio.httpframework.utils;

public class StringUtil {
    public static String toString(Object o) {
        if (o == null) {
            throw new RuntimeException("toString()空指针异常");
        }
        return String.valueOf(o);
    }

    public static String upperFirstWord(String s) {
        char[] chars = s.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);
    }
}
