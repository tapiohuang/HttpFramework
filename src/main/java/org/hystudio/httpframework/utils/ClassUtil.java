package org.hystudio.httpframework.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassUtil {

    private static final Set<String> baseMethod = new HashSet<>(Arrays.asList(
            "getClass", "toString", "hashCode", "equals", "clone", "wait", "notifyAll", "notify"));


    public static LinkedList<Class> getSuperClassList(Class clazz) {
        LinkedList<Class> classes = new LinkedList<>();
        Class superClass = clazz.getSuperclass();
        while (superClass != null) {
            classes.addFirst(superClass);
            if (superClass.getName().equals("java.lang.Object")) {
                break;
            }
            superClass = superClass.getSuperclass();
        }
        return classes;
    }

    public static boolean isExtend(Class c1, Class c2) {
        LinkedList<Class> classes = getSuperClassList(c1);
        return classes.contains(c2);
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

    public static boolean isBaseType(Object object) {
        Class className = object.getClass();
        return className.equals(Integer.class) ||
                className.equals(Byte.class) ||
                className.equals(Long.class) ||
                className.equals(Double.class) ||
                className.equals(Float.class) ||
                className.equals(Character.class) ||
                className.equals(Short.class) ||
                className.equals(String.class) ||
                className.equals(Boolean.class);
    }

    public static ArrayList<Field> getAttributeList(Class clazz, Class<? extends Annotation> filterAnnotation) {
        ArrayList<Field> attributeList = new ArrayList<>();
        ArrayList<Field> tmpAttributeList = (ArrayList<Field>) Stream.of(clazz.getDeclaredFields()).filter(
                field -> {
                    if (filterAnnotation == null) {
                        return true;
                    }
                    return !field.isAnnotationPresent(filterAnnotation);
                }
        ).collect(Collectors.toList());
        return tmpAttributeList;
    }

    public static ArrayList<Field> getAttributeList(Class clazz) {
        return getAttributeList(clazz, null);
    }

    public static ArrayList<Field> getAttributeList(Object o) {
        return getAttributeList(o.getClass(), null);
    }

    public static ArrayList<Field> getAttributeList(Object o, Class<? extends Annotation> filterAnnotation) {
        return getAttributeList(o.getClass(), filterAnnotation);
    }
}
