package com.example.patshopclient.home.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.android_patshopclient.R;
import com.example.lib_http.entity.home.HomeBidProductDTO;
import com.example.patshopclient.common.config.ImageConfig;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by qiubin on 2020-03-12.
 * Describe: 首页拍卖商品adapter
 */
public class BidProductAdapter extends BaseQuickAdapter<HomeBidProductDTO.DataBean.HomeProductDaoListBean, BaseViewHolder> {

    Context mContext;

    public BidProductAdapter(Context context, @Nullable List<HomeBidProductDTO.DataBean.HomeProductDaoListBean> data) {
        super(R.layout.item_bid_product, data);
        this.mContext = context;
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, HomeBidProductDTO.DataBean.HomeProductDaoListBean homeProductDaoListBean) {
        ImageView ivProduct = baseViewHolder.getView(R.id.iv_product);
        ViewGroup.LayoutParams layoutParams = ivProduct.getLayoutParams();
        layoutParams.width = (ScreenUtils.getScreenWidth() - 30) / 2;
        ivProduct.setLayoutParams(layoutParams);
        String imagePath = homeProductDaoListBean.getPic().split(",")[0];
        Glide.with(mContext).load(ImageConfig.MY_IMAGE_PREFIX + imagePath).into(ivProduct);
        baseViewHolder.setText(R.id.tv_introduction, homeProductDaoListBean.getProductName())
                .setText(R.id.tv_pat_coin, "拍拍币：" + homeProductDaoListBean.getPatPrice())
                .setText(R.id.tv_pat_count, "已出价 " + homeProductDaoListBean.getBidCount() + "次")
                .setText(R.id.tv_market_price, "¥ " + homeProductDaoListBean.getMarketPrice());
    }

}