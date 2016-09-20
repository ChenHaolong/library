package com.example.chenhaolong.myframe.presenter;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/16.
 */
public interface CallBack<T> {

    void success(T str);

    void fail(String str);
}
