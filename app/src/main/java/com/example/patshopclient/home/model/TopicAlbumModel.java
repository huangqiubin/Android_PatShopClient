package com.example.patshopclient.home.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by qiubin on 2020-04-22.
 * Describe:发布帖子 图片model
 */
public class TopicAlbumModel implements MultiItemEntity {
    private int type;//0占位图片 1本地图片
    private String imgPath;//本地图片地址

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "TopicAlbumModel{" +
                "type=" + type +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }

    @Override
    public int getItemType() {
        return type;
    }
}
