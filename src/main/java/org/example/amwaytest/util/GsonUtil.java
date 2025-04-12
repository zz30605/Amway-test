package org.example.amwaytest.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class GsonUtil {
    private static final Gson gson = new GsonBuilder()
            .excludeFieldsWithModifiers(new int[] {128, 8})
            .disableHtmlEscaping()
            .create();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }
}
