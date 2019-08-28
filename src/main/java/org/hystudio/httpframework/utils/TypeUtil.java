package org.hystudio.httpframework.utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TypeUtil {

    private final static Set<Class> BASE_DATA_TYPE = new HashSet<Class>(Arrays.asList(
            int.class, double.class, float.class, boolean.class, short.class, byte.class, long.class, char.class,
            Integer.class, Double.class, Float.class, String.class, Boolean.class,
            Short.class, Byte.class, Long.class, Character.class
    ));

    public static Object toType(Object value, Class type) {
        if (value.getClass().equals(type)) {
            return value;
        }
        String valueString = String.valueOf(value);
        if (type.equals(int.class) || type.equals(Integer.TYPE)) {
            return toInt(valueString);
        }
        if (type.equals(float.class) || type.equals(Float.TYPE)) {
            return toFloat(valueString);
        }
        if (type.equals(double.class) || type.equals(Double.TYPE)) {
            return toDouble(valueString);
        }
        if (type.equals(long.class) || type.equals(Long.TYPE)) {
            return toLong(valueString);
        }
        return value;
    }

    private static int toInt(String value) {
        return Integer.parseInt(value.split("\\.")[0]);
    }

    private static float toFloat(String value) {
        return Float.parseFloat(value);
    }

    private static double toDouble(String value) {
        return Double.parseDouble(value);
    }

    private static long toLong(String value) {
        BigDecimal bd = new BigDecimal(value);
        return Long.parseLong(bd.toPlainString());
    }

    public static boolean isBaseType(Class clazz) {
        return BASE_DATA_TYPE.contains(clazz);
    }
}
