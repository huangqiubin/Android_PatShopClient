package com.example.patshopclient.home.adapter

import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.ScreenUtils
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.android_patshopclient.R
import com.example.patshopclient.home.POJO.ProductAlbumPOJO

/**
 * Created by qiubin on 2020-04-22.
 * Describe:发布商品 图片adapter
 */
class ProductAlbumAdapter(albumList: MutableList<ProductAlbumPOJO>) : BaseMultiItemQuickAdapter<ProductAlbumPOJO, BaseViewHolder>() {

    private val widthItem: Int = (ScreenUtils.getScreenWidth() - ConvertUtils.dp2px(80f)) / 4

    init {
        // 绑定 layout 对应的 type
        addItemType(0, R.layout.item_album)//本地图片
        addItemType(1, R.layout.item_album_product)//占位图片
    }

    override fun convert(helper: BaseViewHolder, item: ProductAlbumPOJO) {
        var cardAlbum = helper.getView<CardView>(R.id.card_album)
        var ivLP = cardAlbum.layoutParams
        ivLP.width = widthItem
        ivLP.height = widthItem
        cardAlbum.layoutParams = ivLP
        when (helper.itemViewType) {
            0 -> {
                var ivAlbum = helper.getView<ImageView>(R.id.iv_topic_album)
                Glide.with(context).load(item.imgPath).into(ivAlbum)
            }
        }
    }

}