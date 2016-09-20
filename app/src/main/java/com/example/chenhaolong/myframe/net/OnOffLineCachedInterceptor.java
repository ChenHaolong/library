package com.example.chenhaolong.myframe.net;

import com.example.chenhaolong.myframe.app.MyApp;
import com.example.chenhaolong.myframe.utils.NetworkUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/17.
 */
public class OnOffLineCachedInterceptor implements Interceptor {
    private static final int MAX_AGE = 60;

    @Override public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        if (!NetworkUtils.isConnected(MyApp.mContext)) {
            request = request.newBuilder()
                    //强制使用缓存
                    .cacheControl(CacheControl.FORCE_CACHE).build();
        }

        Response response = chain.proceed(request);

        if (NetworkUtils.isConnected(MyApp.mContext)) {
            int maxAge = MAX_AGE; // 有网络时 设置缓存超时1分钟
            response.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .removeHeader("Pragma")
                    .build();
        } else {
            int maxStale = 60 * 60 * 24 * 28; // 无网络时，设置超时为4周
            response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader("Pragma")
                    .build();
        }
        return response;
    }
}
