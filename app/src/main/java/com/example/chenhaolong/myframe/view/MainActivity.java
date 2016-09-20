package com.example.chenhaolong.myframe.view;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chenhaolong.myframe.R;
import com.example.chenhaolong.myframe.bean.LoginBean;
import com.example.chenhaolong.myframe.net.PicassoUtil;
import com.example.chenhaolong.myframe.presenter.PresenterImp;
import com.example.chenhaolong.myframe.utils.DownloadServer;
import com.example.chenhaolong.myframe.view.viewinterface.ViewImpl1;

import java.io.File;

public class MainActivity extends BaseActivity<ViewImpl1, PresenterImp> implements ViewImpl1, View.OnClickListener {

    private TextView tv;
    private ImageView iv;

    @Override
    protected void initVariables() {
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        iv= (ImageView) findViewById(R.id.imageView);
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
