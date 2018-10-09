package com.blob.module.common.sys.entity;

/**
 * Created by cc on 2018/10/9.
 */
public class HttpResult {

    //状态码
    private int code;

    //返回数据
    private Object datas;

    //返回说明
    private String msg;

    static HttpResult httpResult = null;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static HttpResult built(int code, String msg, Object data){
        httpResult = new HttpResult();
        httpResult.setCode(code);
        httpResult.setMsg(msg);
        httpResult.setDatas(data);
        return httpResult;
    }
}
