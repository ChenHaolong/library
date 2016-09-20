package com.example.chenhaolong.myframe.presenter;

import com.example.chenhaolong.myframe.bean.BaseBean;
import com.example.chenhaolong.myframe.bean.LoginBean;
import com.example.chenhaolong.myframe.net.ApiFactory;
import com.example.chenhaolong.myframe.net.ApiStores;
import com.example.chenhaolong.myframe.view.viewinterface.ViewImpl1;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/15.
 */
public class PresenterImp extends BasePresenter<ViewImpl1> {

    /**
     * 请求网络
     */
    @Override
    public void request() {
        if (getView() == null) {
            return;
        }
        getView().showLoading();
        Map<String, Object> params = new HashMap<>();
        params.put("un", "13119110371");
        params.put("pw", "12345678");
        params.put("mid", "13119110371");
        params.put("pushsvc", 2);
        params.put("ct", 1);
        ApiFactory.getServer(ApiStores.class).login(params).enqueue(new Callback<BaseBean<LoginBean>>() {
            @Override
            public void onResponse(Call<BaseBean<LoginBean>> call, Response<BaseBean<LoginBean>> response) {
                if (response.isSuccessful()){
                    BaseBean<LoginBean> baseBean = response.body();
                    if (baseBean.getCode()==1){
                        getView().showSuccessMsg(response.body().getResult());
                    }else {
                        distributedHandler(baseBean.getCode(), getView());
                    }
                }else {
                    getView().showFaildMsg(0, "网络异常");
                }
            }

            @Override
            public void onFailure(Call<BaseBean<LoginBean>> call, Throwable t) {
                getView().showFaildMsg(0, "访问异常");
            }
        });
    }

}
