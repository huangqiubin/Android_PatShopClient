package com.example.patshopclient.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.lib_http.entity.home.HomeContentDTO;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

/**
 * Created by qiubin on 2020-03-16.
 * Describe: 主页home banner
 */
public class MainHomeBannerAdapter extends BannerAdapter<HomeContentDTO.DataBean.HomeAdvertiseListBean, MainHomeBannerAdapter.ImageHolder> {


    public MainHomeBannerAdapter(List<HomeContentDTO.DataBean.HomeAdvertiseListBean> datas) {
        super(datas);
    }

    public void updataDatas(List<HomeContentDTO.DataBean.HomeAdvertiseListBean> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new ImageHolder(imageView);
    }

    @Override
    public void onBindView(ImageHolder holder, HomeContentDTO.DataBean.HomeAdvertiseListBean data, int position, int size) {
        Glide.with(holder.imageView).load(data.getPic()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(holder.imageView);
    }

    public class ImageHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView;
        }
    }
}
