package com.example.patshopclient.home.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.android_patshopclient.R;
import com.example.patshopclient.common.util.image.ImageConfig;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by qiubin on 2020-03-21.
 * Describe:
 */
public class ItemProductDetailAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ItemProductDetailAdapter(@Nullable List<String> data) {
        super(R.layout.item_product_detail, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, String s) {
        ImageView imageView = baseViewHolder.getView(R.id.iv_item);
        Glide.with(getContext()).load(s).into(imageView);
    }


}
