package org.hystudio.httpframework.utils;

public class ClassUtil {

    public static boolean isImplement(Class c1, Class c2) {
        Class[] interfaces = c1.getInterfaces();
        for (Class interfaceClass : interfaces
        ) {
            if (interfaceClass.equals(c2)) {
                return true;
            }
        }
        return false;
    }
}
