package com.example.patshopclient.home.adapter;

import android.widget.ImageView;

import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.android_patshopclient.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by qiubin on 2020-03-24.
 * Describe:
 */
public class ProductDetailImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ProductDetailImageAdapter(@Nullable List<String> data) {
        super(R.layout.item_product_detail, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, String s) {
        int screenWidth = ScreenUtils.getScreenWidth();
        ImageView imageView = baseViewHolder.getView(R.id.iv_item);
        Glide.with(getContext()).load(s).placeholder(R.drawable.icon_placeholer).into(imageView);
    }
}
