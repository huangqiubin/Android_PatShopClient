package com.example.patshopclient.home.adapter

import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.ScreenUtils
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.android_patshopclient.R
import com.example.patshopclient.home.model.TopicAlbumModel

/**
 * Created by qiubin on 2020-04-22.
 * Describe:发布话题 图片adapter
 */
class TopicAlbumAdapter(albumList: MutableList<TopicAlbumModel>) : BaseMultiItemQuickAdapter<TopicAlbumModel, BaseViewHolder>() {

    private val widthItem: Int = (ScreenUtils.getScreenWidth() - ConvertUtils.dp2px(33f)) / 4

    init {
        // 绑定 layout 对应的 type
        addItemType(0, R.layout.item_album)
        addItemType(1, R.layout.item_album_spec)
    }

    override fun convert(helper: BaseViewHolder, item: TopicAlbumModel) {
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
            1 -> {
                addChildClickViewIds(R.id.ll_album)
            }
        }

    }

}