package org.hystudio.httpframework.utils;

public class InterfaceUtil {
    public static boolean isInterface(Class clazz) {
        return clazz.isInterface();
    }

    public static boolean isInterface(Object o) {
        return isInterface(o.getClass());
    }
}
