package com.example.chenhaolong.myframe.view;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chl.customview.imageview.ScaleImageView;
import com.example.chenhaolong.myframe.R;
import com.example.chenhaolong.myframe.bean.LoginBean;
import com.example.chenhaolong.myframe.net.PicassoUtil;
import com.example.chenhaolong.myframe.presenter.PresenterImp;
import com.example.chenhaolong.myframe.view.viewinterface.ViewImpl1;


public class MainActivity extends BaseActivity<ViewImpl1, PresenterImp> implements ViewImpl1, View.OnClickListener {

    private TextView tv;

    private ScaleImageView iv;

    @Override
    protected void initVariables() {
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        iv= (ScaleImageView) findViewById(R.id.imageView);
        iv.setScaleX(5);
        iv.setScaleY(6);
        iv.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        mPresenter.request();
        PicassoUtil.INSTANCE.getPicasso().load("http://p4.so.qhmsg.com/bdr/_240_/t01e5bc61862335bc14.jpg").into(iv);
    }

    @Override
    protected PresenterImp createPresenter() {
        return new PresenterImp();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "正在加载。。。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hindLoad() {

    }

    @Override
    public void showSuccessMsg(LoginBean msg) {
        tv.setText(msg.getUsername());
    }

    @Override
    public void showFaildMsg(int code, String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
