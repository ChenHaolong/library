package com.example.chenhaolong.myframe.net;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/17.
 */
public class ApiFactory {
    public static  <T> T getServer(Class<T> cls){
        return RetrofitClient.INSTANCE.getRetrofit().create(cls);
    }

}
