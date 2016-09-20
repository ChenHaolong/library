package com.example.chenhaolong.myframe.presenter;

import com.example.chenhaolong.myframe.view.viewinterface.BaseView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/12.
 */
public abstract class BasePresenter<T> {

    protected Reference<T> mViewRef;//View接口类型的弱引用

    /**
     * 当view创建时，绑定View，用来接口回调
     * @param view
     */
    public void attachView(T view){

        mViewRef=new WeakReference<>(view);//建立关系

    }

    protected T getView(){

        return isViewAttached()?mViewRef.get():null;
    }

    public boolean isViewAttached(){

        return mViewRef!=null&&mViewRef.get()!=null;
    }


    /**
     * view销毁时，解除绑定
     */
    public void detachView(){

        if (mViewRef!=null){

            mViewRef.clear();
            mViewRef=null;
        }

    }

    void distributedHandler(int code, BaseView view){
        int baseCode=0;
        switch (code){
            case 1011:
                view.showFaildMsg(code, "无效的session");
                break;
            case 1012:
                view.showFaildMsg(baseCode, "没有发现更新");
                break;
            default:
                view.showFaildMsg(baseCode, "请求失败");
                break;
        }
    };

    abstract void request();

}
