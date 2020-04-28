package com.example.patshopclient.home.adapter;

import android.text.Html;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.android_patshopclient.R;
import com.example.lib_http.entity.home.TopicListDTO;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by qiubin on 2020-04-19.
 * Describe: 热门话题adapter
 */
public class TopicListAdapter extends BaseQuickAdapter<TopicListDTO.DataBean.HotTopicListBean, BaseViewHolder> {

    public TopicListAdapter(int layoutResId, @Nullable List<TopicListDTO.DataBean.HotTopicListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, TopicListDTO.DataBean.HotTopicListBean hotTopicListBean) {
        int id = hotTopicListBean.getId();
        TextView tvRankNum = baseViewHolder.getView(R.id.tvRankNum);
        if (id < 4) {
            tvRankNum.setText(Html.fromHtml("<font color=\"#ab3b3a\">" + id + ".</font>"));
        } else {
            tvRankNum.setText(id + ".");
        }
        baseViewHolder.setText(R.id.tvTitle, hotTopicListBean.getSecTopicName());
        if (hotTopicListBean.getIsHot() == 1) {
            baseViewHolder.setVisible(R.id.tv_iconHot, true);
        }
    }
}
