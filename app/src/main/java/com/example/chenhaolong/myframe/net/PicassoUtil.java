package com.example.chenhaolong.myframe.net;

import android.graphics.Bitmap;

import com.example.chenhaolong.myframe.app.MyApp;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/19.
 */

public enum  PicassoUtil {
    INSTANCE;
    private Picasso picasso;
    PicassoUtil(){
        picasso = new Picasso.Builder(MyApp.mContext)
                .memoryCache(new LruCache(10<<20 ))
                .defaultBitmapConfig(Bitmap.Config.RGB_565)
                .downloader(new OkHttp3Downloader())
                .indicatorsEnabled(false)
                .build();
    }

    public Picasso getPicasso(){
        return picasso;
    }
}
