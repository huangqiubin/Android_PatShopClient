package com.example.lib_http.entity.home;

/**
 * Created by qiubin on 2020-05-02.
 * Describe:
 */
public class BidProductResultDTO {

    /**
     * code : 200
     * message : 竞拍成功
     * data : 0
     */

    private int code;
    private String message;
    private int data;//-1用户不存在 1竞拍结束 2竞拍失败 3重复出价 4出价过低 0竞拍成功

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
