package com.example.chenhaolong.myframe.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chenhaolong.myframe.presenter.BasePresenter;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/12.
 */
public abstract class BaseFragment<V,T extends BasePresenter<V>> extends Fragment {
    protected T mPresenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=createPresenter();//创建presenter
        mPresenter.attachView((V) this);
        initVariables();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(getContentId(),container,false);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract void initVariables();
    protected abstract int getContentId();
    protected abstract void loadData();
    protected abstract T createPresenter();
}
