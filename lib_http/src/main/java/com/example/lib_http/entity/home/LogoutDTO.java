package com.example.lib_http.entity.home;

/**
 * Created by qiubin on 2020/6/3.
 * Describe:
 */
public class LogoutDTO {

    /**
     * code : 200
     * message : 操作成功
     * data : 1
     */

    private int code;
    private String message;
    private int data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
