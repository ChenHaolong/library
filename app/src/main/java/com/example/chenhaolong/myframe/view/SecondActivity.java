package com.example.chenhaolong.myframe.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chenhaolong.myframe.R;
import com.example.chenhaolong.myframe.bean.RvBean;
import com.example.chenhaolong.myframe.presenter.BasePresenter;
import com.example.chenhaolong.myframe.presenter.PresenterImp2;
import com.example.chenhaolong.myframe.view.viewinterface.ViewImpl2;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends BaseActivity<ViewImpl2, PresenterImp2> implements ViewImpl2 {

    private RecyclerView recyclerView;

    private RvAdapter adapter;

    private List<RvBean> datas=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_second);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
    }

    @Override
    protected void loadData() {
        adapter=new RvAdapter(this, R.layout.item, datas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        mPresenter.request();
    }

    @Override
    protected PresenterImp2 createPresenter() {
        return new PresenterImp2();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hindLoad() {

    }

    @Override
    public void showFaildMsg(int code, String errMsg) {

    }

    @Override
    public void showSuccessMsg(List<RvBean> bean) {
        for (RvBean rvBean : bean) {
            datas.add(rvBean);
        }
        adapter.notifyDataSetChanged();
    }
}
