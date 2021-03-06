package com.example.chenhaolong.myframe.net;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/17.
 */
public class AllCachedInterceptor implements Interceptor {
    private static final int MAX_AGE = 60;

    @Override public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

    /*
      自己设置的请求头中没有设置Cache-Control的话就添加
      //自己请求头中添加特定header
      @Headers("Cache-Control: max-age=60,max-stale=60")
      @GET Call<Daily> getNewsList(@Url String url);
     */
        String cacheControl = request.cacheControl().toString();

        if (TextUtils.isEmpty(cacheControl)) {
            cacheControl = "public, max-age=" + MAX_AGE;
        }

        Response response = chain.proceed(request);

        //设置response的Cache-Control,设置缓存时间
        return response.newBuilder()
                .header("Cache-Control", cacheControl)
                .removeHeader("Pragma")
                .build();
    }
}
