package com.example.lib_http.entity.home;

/**
 * Created by qiubin on 2020-05-03.
 * Describe:
 */
public class LoginDTO {

    /**
     * code : 200
     * message : 登陆成功
     * data : 144866FE1FE52315BA5820E5B3AA614B
     */

    private int code;
    private String message;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
