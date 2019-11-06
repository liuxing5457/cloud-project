package com.example.cloudcommons.resp;

import java.io.Serializable;

public class ResponseMsg<T> implements Serializable {

    private int code = Code.SUCCESS;

    private T data;

    private String msg;

    private String redirectUrl;

    private boolean back;

    private boolean refresh;

    public ResponseMsg() {
        this.code = Code.SUCCESS;
        this.msg = Code.SUCCESS_MSG;
    }

    public ResponseMsg(T data) {
        this.data = data;
        this.code = Code.SUCCESS;
        this.msg = Code.SUCCESS_MSG;
    }

    public ResponseMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseMsg(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public ResponseMsg setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
        return this;
    }

    public boolean isBack() {
        return back;
    }

    public ResponseMsg setBack(boolean back) {
        this.back = back;
        return this;
    }

    public boolean isRefresh() {
        return refresh;
    }

    public ResponseMsg setRefresh(boolean refresh) {
        this.refresh = refresh;
        return this;
    }

    @Override
    public String toString() {
        return "ResponseMsg{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                ", redirectUrl='" + redirectUrl + '\'' +
                ", back=" + back +
                ", refresh=" + refresh +
                '}';
    }
}

