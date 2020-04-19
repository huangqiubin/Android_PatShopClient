package com.example.patshopclient.home.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.android_patshopclient.R;
import com.example.lib_http.entity.home.CommunityTopicDTO;
import com.example.patshopclient.common.util.image.ImageConfig;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by qiubin on 2020-04-17.
 * Describe:Topic adapter
 */
public class TopicAdapter extends BaseQuickAdapter<CommunityTopicDTO.DataBean.TopicListBean, BaseViewHolder> {

    public TopicAdapter(int layoutResId, @Nullable List<CommunityTopicDTO.DataBean.TopicListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, CommunityTopicDTO.DataBean.TopicListBean topicListBean) {
        RecyclerView imageRecycler = baseViewHolder.getView(R.id.recycler_topic_image);
        imageRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
        imageRecycler.setHasFixedSize(true);
        imageRecycler.setNestedScrollingEnabled(false);
        List<String> imageList = Arrays.asList(topicListBean.getTopicImage().split(","));
        TopicImageAdapter imageAdapter = new TopicImageAdapter(R.layout.item_topic_image, imageList);
        imageRecycler.setAdapter(imageAdapter);
        ImageView ivAvatar = baseViewHolder.getView(R.id.iv_avatar);
        imageRecycler.setAdapter(imageAdapter);
        Glide.with(getContext()).load(ImageConfig.MY_IMAGE_PREFIX + topicListBean.getUserAvatar()).placeholder(R.mipmap.avatar_placeholder).into(ivAvatar);
        LogUtils.d("huangqiubin", "topicTime:" + TimeUtils.string2Date((topicListBean.getCreateTime()), "yyyy/MM/dd HH:mm"));
        baseViewHolder.setText(R.id.tv_sec_topic_type, topicListBean.getSmsSecTopic().getSecTopicName())
                .setText(R.id.tv_nickname, topicListBean.getUserNickName())
                .setText(R.id.tv_date, topicListBean.getCreateTime())
                .setText(R.id.tv_topic_content, topicListBean.getTopicContent())
                .setText(R.id.tv_browse, "热度 " + topicListBean.getTopicHotValue());
    }

    public static class TopicImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public TopicImageAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NotNull BaseViewHolder baseViewHolder, String s) {
            ImageView imageView = baseViewHolder.getView(R.id.iv_topic);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = (ScreenUtils.getScreenWidth() - 50) / 3;
            imageView.setLayoutParams(layoutParams);
            Glide.with(getContext()).load(ImageConfig.MY_IMAGE_PREFIX + s).placeholder(R.mipmap.icon_placeholer).into(imageView);
        }
    }


}
