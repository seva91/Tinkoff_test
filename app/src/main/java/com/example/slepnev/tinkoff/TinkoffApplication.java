package com.example.slepnev.tinkoff;

import android.app.Application;
import android.content.Context;

/**
 * Created by slepnev on 13.03.16.
 */
public class TinkoffApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }
}
