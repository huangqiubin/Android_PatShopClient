package com.example.patshopclient.home.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

/**
 * Created by qiubin on 2020-03-21.
 * Describe:
 */
public class ProductDetailBannerAdapter extends BannerAdapter<String, ProductDetailBannerAdapter.ImageHolder> {



    public ProductDetailBannerAdapter(List<String> datas) {
        super(datas);
    }

    public void updateData(List<String> data) {
        mDatas.addAll(data);
        notifyDataSetChanged();

    }

    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return new ImageHolder(imageView);
    }

    @Override
    public void onBindView(ImageHolder holder, String data, int position, int size) {
        Glide.with(holder.imageView).load(data).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(holder.imageView);
    }

    public class ImageHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView;
        }
    }
}
