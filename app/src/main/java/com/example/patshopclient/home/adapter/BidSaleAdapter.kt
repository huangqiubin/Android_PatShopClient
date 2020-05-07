package com.example.patshopclient.home.adapter

import android.widget.ImageView
import android.widget.TextView
import com.blankj.utilcode.util.SpanUtils
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.android_patshopclient.R
import com.example.lib_http.entity.home.BidSaleListDTO
import com.example.patshopclient.common.config.ImageConfig

/**
 * Created by qiubin on 2020-05-04.
 * Describe:参拍adapter
 */
class BidSaleAdapter(data: MutableList<BidSaleListDTO.DataBean.BidResultModelListBean>?) : BaseQuickAdapter<BidSaleListDTO.DataBean.BidResultModelListBean, BaseViewHolder>(R.layout.item_bid_sale, data) {

    override fun convert(helper: BaseViewHolder, item: BidSaleListDTO.DataBean.BidResultModelListBean) {

        var ivProduct = helper.getView<ImageView>(R.id.iv_product)
        Glide.with(context).load(ImageConfig.MY_IMAGE_PREFIX + item.productIcon).placeholder(R.mipmap.icon_placeholer).into(ivProduct)
        var tvBidResult = helper.getView<TextView>(R.id.tv_bid_result)
        var bidResult = when (item.bidResult) {
            0 -> SpanUtils.with(tvBidResult).append("竞拍成功").create()
            1 -> SpanUtils.with(tvBidResult).append("竞拍失败").setForegroundColor(context.resources.getColor(R.color.color_333333)).create()
            2 -> SpanUtils.with(tvBidResult).append("领先").create()
            3 -> SpanUtils.with(tvBidResult).append("落后").create()
            else -> ""
        }
        helper.setText(R.id.tv_introduction, item.productTitle)
                .setText(R.id.tv_pat_coin, "拍拍币：" + item.productBidCoin)
                .setText(R.id.tv_pat_count, "已出价 " + item.productBidNum)

    }
}