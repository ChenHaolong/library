package com.example.chenhaolong.myframe.app;

import android.app.Application;
import android.content.Context;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/17.
 */
public class MyApp extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;

    }
}
