package com.example.chenhaolong.myframe.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.chenhaolong.myframe.presenter.BasePresenter;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/12.
 */
public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {

    protected T mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=createPresenter();//创建presenter
        mPresenter.attachView((V) this);

        initVariables();
        initViews(savedInstanceState);
        loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    /**
         初始化变量，接受其他页面传递的参数
     */
    protected abstract void initVariables();
    /**
     初始化布局文件、控件
     */
    protected abstract void initViews(Bundle savedInstanceState);
    /**
     加载数据
     */
    protected abstract void loadData();

    protected abstract T createPresenter();
}
