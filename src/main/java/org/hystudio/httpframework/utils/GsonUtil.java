package org.hystudio.httpframework.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
    private static Gson mGson = new Gson();
    

    public GsonUtil() {
        GsonUtil.mGson = new Gson();
    }

    public static <T> T fromJson(String s, Class<T> c) {
        return mGson.fromJson(s, c);
    }

    public static String toJson(Object o) {
        return mGson.toJson(o);
    }

}
