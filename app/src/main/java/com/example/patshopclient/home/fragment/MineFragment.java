package com.example.patshopclient.home.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ObjectUtils;
import com.bumptech.glide.Glide;
import com.example.android_patshopclient.R;
import com.example.lib_http.entity.home.MineContentDTO;
import com.example.lib_userinfo.config.UserInfoBean;
import com.example.patshopclient.common.config.PathConfig;
import com.example.patshopclient.common.mvvm.BaseMvvmFragment;
import com.example.patshopclient.common.config.ImageConfig;
import com.example.patshopclient.home.factory.MainViewModelFactory;
import com.example.patshopclient.home.viewmodel.MineViewModel;

/**
 * Created by qiubin on 2020-03-15.
 * Describe:
 */
public class MineFragment extends BaseMvvmFragment<MineViewModel> {

    private ImageView ivHead;
    private ImageView ivSex;
    private TextView tvNickName;
    private TextView tvUserName;
    private TextView tvSignature;
    private LinearLayout llBidSale;
    private LinearLayout llLikeSale;
    private LinearLayout llTraceSale;
    private TextView tvBidSale;
    private TextView tvLikeSale;
    private TextView tvTraceSale;
    private LinearLayout llGoingSend;
    private LinearLayout llGoingReceive;
    private LinearLayout llHistoryOrder;
    private CardView cardSaleManager;

    @Override
    public int onBindLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView(View view) {
        ivHead = rootView.findViewById(R.id.iv_head);
        ivSex = rootView.findViewById(R.id.iv_sex);
        tvNickName = rootView.findViewById(R.id.tv_nickname);
        tvUserName = rootView.findViewById(R.id.tv_username);
        tvSignature = rootView.findViewById(R.id.tv_signature);
        llBidSale = rootView.findViewById(R.id.ll_bid_sale);
        llLikeSale = rootView.findViewById(R.id.ll_like_sale);
        llTraceSale = rootView.findViewById(R.id.ll_trace_sale);
        tvBidSale = rootView.findViewById(R.id.tv_bid_sale);
        tvLikeSale = rootView.findViewById(R.id.tv_like_sale);
        tvTraceSale = rootView.findViewById(R.id.tv_trace_sale);
        llGoingSend = rootView.findViewById(R.id.ll_going_send);
        llGoingReceive = rootView.findViewById(R.id.ll_going_receive);
        llHistoryOrder = rootView.findViewById(R.id.ll_history_order);
        cardSaleManager = rootView.findViewById(R.id.card_sale_manage);
    }

    @Override
    public void initData() {
        String userName = UserInfoBean.getInstance().getUname();
        mViewModel.getMineContent(userName);
    }

    @Override
    public void initListener() {
        super.initListener();

        //参拍
        llBidSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(PathConfig.BIDSALE).navigation();
            }
        });

        //围观
        llLikeSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(PathConfig.ONLOOK).navigation();
            }
        });

        //足迹
        llTraceSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(PathConfig.TRACEFOOT).navigation();
            }
        });

        //待发货
        llGoingSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(PathConfig.DELIVERY).navigation();
            }
        });

        //待收货
        llGoingReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(PathConfig.RECEIVE).navigation();
            }
        });

        //历史订单
        llHistoryOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(PathConfig.HISTORICAL_ORDER).navigation();
            }
        });

        //商品管理
        cardSaleManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public String getToolbarTitle() {
        return null;
    }

    @Override
    public Class<MineViewModel> onBindViewModel() {
        return MineViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return MainViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {
        mViewModel.getMineContentLiveEvent().observe(this, new Observer<MineContentDTO>() {
            @Override
            public void onChanged(MineContentDTO mineContentDTO) {
                if (ObjectUtils.isEmpty(mineContentDTO)) {
                    return;
                }
                MineContentDTO.DataBean.MemberDaoBean memberDaoBean = mineContentDTO.getData().getMemberDao();
                MineContentDTO.DataBean.BidNumPOJOBean bidNumPOJOBean = mineContentDTO.getData().getBidNumPOJO();
                Glide.with(getContext()).load(ImageConfig.MY_IMAGE_PREFIX + memberDaoBean.getIcon()).placeholder(R.mipmap.avatar_placeholder).centerCrop().into(ivHead);


                tvUserName.setText("账号：" + memberDaoBean.getUsername());
                tvNickName.setText(memberDaoBean.getNickname());
                tvSignature.setText("个性签名：" + memberDaoBean.getPersonalizedSignature());
                tvBidSale.setText(bidNumPOJOBean.getBidNum() + "");
                tvLikeSale.setText(bidNumPOJOBean.getOnLooks() + "");
                tvTraceSale.setText(bidNumPOJOBean.getFootPrint() + "");
                if (ObjectUtils.isNotEmpty(memberDaoBean.getGender())) {
                    Glide.with(getContext()).load(memberDaoBean.getGender() == 1 ? R.mipmap.woman : R.mipmap.man).placeholder(R.mipmap.icon_placeholer).centerCrop().into(ivSex);
                    ivSex.setVisibility(View.VISIBLE);
                }
                //是管理员
                if (memberDaoBean.getManager() == 1){
                    cardSaleManager.setVisibility(View.VISIBLE);
                }else {
                    cardSaleManager.setVisibility(View.GONE);
                }
            }
        });
    }

}
