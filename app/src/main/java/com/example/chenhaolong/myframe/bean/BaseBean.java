package com.example.chenhaolong.myframe.bean;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/8/18.
 */
public class BaseBean<T> {

    private int code;
    private String msg;
    private T result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
