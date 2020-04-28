package com.example.patshopclient.home.dialog;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.android_patshopclient.R;
import com.example.patshopclient.common.basedialog.BaseCenterDialog;

/**
 * Created by qiubin on 2020-04-21.
 * Describe:发起帖子选择二级话题类型
 */
public class DialogChooseTopicType extends BaseCenterDialog {

    protected DialogChooseTopicType(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_choose_topic_type;
    }
}
