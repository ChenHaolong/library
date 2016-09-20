package com.example.chenhaolong.myframe.presenter;

import com.example.chenhaolong.myframe.bean.RvBean;
import com.example.chenhaolong.myframe.net.PicassoUtil;
import com.example.chenhaolong.myframe.view.viewinterface.ViewImpl2;

import java.util.ArrayList;
import java.util.List;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/9/18.
 */

public class PresenterImp2 extends BasePresenter<ViewImpl2> {
    private RvBean rvClone;
    @Override
    public void request() {
        if (getView() == null) {
            return;
        }
        getView().showLoading();

        List<RvBean> datas=new ArrayList<>();
        RvBean rv = new RvBean();
        rv.setImageUrl("http://p4.so.qhmsg.com/bdr/_240_/t01e5bc61862335bc14.jpg");
        for (int i = 0; i < 30; i++) {
            rvClone=rv.clone();
            rvClone.setName("图"+i);
            datas.add(rvClone);
        }

        getView().showSuccessMsg(datas);


    }
}
