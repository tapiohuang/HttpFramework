package org.hystudio.httpframework.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ClassUtil {

    private static final Set<String> baseMethod = new HashSet<>(Arrays.asList("toString", "hashCode", "equals", "clone"));

    public static void callMethod(Method method, Object target, Object... args) {
        try {
            method.invoke(target, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

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

    public static HashMap<String, Method> getMethodMap(Object o) {
        return getMethodMap(o.getClass());
    }

    public static HashMap<String, Method> getMethodMap(Class clazz) {
        Method[] methods = clazz.getMethods();
        HashMap<String, Method> methodHashMap = new HashMap<>();
        for (Method m : methods
        ) {
            methodHashMap.put(m.getName(), m);
        }
        return methodHashMap;
    }

    public static boolean isBaseMethod(Method method) {
        String methodName = method.getName();
        return baseMethod.contains(methodName);
    }
}
