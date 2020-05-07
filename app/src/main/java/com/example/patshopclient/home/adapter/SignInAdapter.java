package com.example.patshopclient.home.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.android_patshopclient.R;
import com.example.lib_http.pojo.SignInPOJO;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by qiubin on 2020-05-05.
 * Describe:
 */
public class SignInAdapter extends BaseQuickAdapter<SignInPOJO, BaseViewHolder> {

    private int width;

    public SignInAdapter(@Nullable List<SignInPOJO> sign) {
        super(R.layout.item_sign_in, sign);
        width = ScreenUtils.getScreenWidth();
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, SignInPOJO signInPOJO) {
        int itemWidth = (width - ConvertUtils.dp2px(50)) / 7;
        Log.d("huangqiubin", "itemWidth:" + itemWidth);
        RelativeLayout rlDay = baseViewHolder.getView(R.id.rl_day);
        ViewGroup.LayoutParams layoutParams = rlDay.getLayoutParams();
        layoutParams.width = itemWidth;
        rlDay.setLayoutParams(layoutParams);
        ImageView ivGift = baseViewHolder.getView(R.id.iv_gift);
        if (signInPOJO.getDay() == 7) {
            ivGift.setVisibility(View.VISIBLE);
            baseViewHolder.setVisible(R.id.tv_coin, false);
        } else {
            ivGift.setVisibility(View.GONE);
            baseViewHolder.setVisible(R.id.tv_coin, true);
            baseViewHolder.setText(R.id.tv_coin, signInPOJO.getDay() + 2 + "");
            TextView tvCoin = baseViewHolder.getView(R.id.tv_coin);
            tvCoin.setSelected(signInPOJO.isSign());
        }
        baseViewHolder.setText(R.id.tv_day_msg, signInPOJO.getDay() + " day");
    }
}
