package com.kaka.app.til.utils;

import android.widget.Toast;

import com.kaka.app.til.TilApp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Alexandr.Salin on 6/20/15.
 */
public class CommonUtils {

    public static void showToast(String text) {
        Toast.makeText(TilApp.getInstance(), text, Toast.LENGTH_SHORT).show();
    }

    public static final boolean isEmpty(Collection<?> collection) {
        boolean result = false;
        if (collection == null || collection.isEmpty()) {
            result = true;
        }
        return result;
    }

    public static <T> Class<T> getGenericClass(Collection<T> collection) {
        if (isEmpty(collection)) {
            throw new IllegalArgumentException("add() " + ((collection == null) ? "null" : "empty") + " collection");
        }
        return (Class<T>) collection.iterator().next().getClass();

    }

    public static <T> List<T> getNewArrayList() {
        return new ArrayList<T>();
    }
}
