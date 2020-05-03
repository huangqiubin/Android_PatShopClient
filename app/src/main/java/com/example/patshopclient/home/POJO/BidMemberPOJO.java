package com.example.patshopclient.home.POJO;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by qiubin on 2020-04-29.
 * Describe:
 */
public class BidMemberPOJO implements MultiItemEntity {

    private int position;//竞拍排名
    private String avatar;//头像
    private String nickName;//昵称
    private String rmb;//竞拍价格
    private String patTime;//竞拍时间
    private String userId;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRmb() {
        return rmb;
    }

    public void setRmb(String rmb) {
        this.rmb = rmb;
    }

    public String getPatTime() {
        return patTime;
    }

    public void setPatTime(String patTime) {
        this.patTime = patTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BidMemberPOJO{" +
                "position=" + position +
                ", avatar='" + avatar + '\'' +
                ", nickName='" + nickName + '\'' +
                ", rmb='" + rmb + '\'' +
                ", patTime='" + patTime + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    @Override
    public int getItemType() {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
