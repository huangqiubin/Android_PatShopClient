package com.example.patshopclient.home.adapter;

import android.content.Context;
import android.text.Html;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.android_patshopclient.R;
import com.example.patshopclient.common.util.image.ImageConfig;
import com.example.patshopclient.home.POJO.BidMemberPOJO;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by qiubin on 2020-04-29.
 * Describe:商品详情 出价列表adapter
 */
public class BidMemberAdapter extends BaseMultiItemQuickAdapter<BidMemberPOJO, BaseViewHolder> {

    private Context mContext;

    public BidMemberAdapter(Context context, @Nullable List<BidMemberPOJO> data) {
        super(data);
        this.mContext = context;
        addItemType(0, R.layout.item_bid_first);
        addItemType(1, R.layout.item_bid_behind);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, BidMemberPOJO bidMemberPOJO) {
        baseViewHolder.setText(R.id.tv_nickname, bidMemberPOJO.getNickName())
                .setText(R.id.tv_bid_time, bidMemberPOJO.getPatTime());
        ImageView ivAvatar = baseViewHolder.getView(R.id.iv_avatar);
        Glide.with(mContext).load(ImageConfig.MY_IMAGE_PREFIX + bidMemberPOJO.getAvatar()).placeholder(R.mipmap.avatar_placeholder).into(ivAvatar);
        if (baseViewHolder.getItemViewType() == 0) {
            baseViewHolder.setText(R.id.tv_rmb, Html.fromHtml("若无人出价，将以 <font color='#FFD900'>" + bidMemberPOJO.getRmb() + "拍拍币</font> 获得本品"));
        } else if (baseViewHolder.getItemViewType() == 1) {
            baseViewHolder.setText(R.id.tv_rmb, "¥ " + bidMemberPOJO.getRmb());
        }
    }
}
