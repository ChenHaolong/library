package com.example.chenhaolong.myframe.net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/17.
 */
enum RetrofitClient {
    INSTANCE;
    private final Retrofit retrofit;
    RetrofitClient() {
        retrofit = new Retrofit.Builder()
                //设置OKHttpClient
                .client(OKHttpFactory.INSTANCE.getOkHttpClient())
                //baseUrl
                .baseUrl(HttpApi.BASE_URL)
                //gson转化器
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public Retrofit getRetrofit() {
        return retrofit;
    }
}
