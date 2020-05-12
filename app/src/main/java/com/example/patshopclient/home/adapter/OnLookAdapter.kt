package com.example.patshopclient.home.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.android_patshopclient.R
import com.example.lib_http.entity.home.OnLookListDTO
import com.example.patshopclient.common.config.ImageConfig

/**
 * Created by qiubin on 2020-05-04.
 * Describe:参拍adapter
 */
class OnLookAdapter(data: MutableList<OnLookListDTO.DataBean.OnLookListBean>?) : BaseQuickAdapter<OnLookListDTO.DataBean.OnLookListBean, BaseViewHolder>(R.layout.item_bid_sale, data) {

    override fun convert(helper: BaseViewHolder, item: OnLookListDTO.DataBean.OnLookListBean) {

        var ivProduct = helper.getView<ImageView>(R.id.iv_product)
        Glide.with(context).load(ImageConfig.MY_IMAGE_PREFIX + item.pic).placeholder(R.mipmap.icon_placeholer).into(ivProduct)
        helper.setText(R.id.tv_introduction, item.title)
                .setText(R.id.tv_pat_coin, "拍拍币：" + item.bidPrice)
                .setText(R.id.tv_pat_count, "已出价 " + item.bids + "人")
                .setText(R.id.tv_bid_result,item.bidState)

    }
}