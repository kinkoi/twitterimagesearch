package com.kaka.app.til;

import android.app.Application;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Alexandr.Salin on 7/27/15.
 */
public class TilApp extends Application {
    private static TilApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initTwitterApi();
    }

    public static TilApp getInstance() {
        return instance;
    }

    private void initTwitterApi() {
        Fabric.with(this);
    }
}
