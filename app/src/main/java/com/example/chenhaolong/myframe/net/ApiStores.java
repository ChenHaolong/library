package com.example.chenhaolong.myframe.net;

import com.example.chenhaolong.myframe.bean.BaseBean;
import com.example.chenhaolong.myframe.bean.LoginBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/18.
 */
public interface ApiStores {
    @FormUrlEncoded
    @POST(HttpApi.LOGIN)
    Call<BaseBean<LoginBean>> login(@FieldMap Map<String, Object> params);
}
