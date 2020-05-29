package com.example.patshopclient.home.activity;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SpanUtils;
import com.example.android_patshopclient.R;
import com.example.lib_http.entity.home.ProductDetailDTO;
import com.example.lib_userinfo.config.UserInfoBean;
import com.example.patshopclient.common.config.PathConfig;
import com.example.patshopclient.common.mvvm.BaseMvvmActivity;
import com.example.patshopclient.common.config.ImageConfig;
import com.example.patshopclient.home.POJO.BidMemberPOJO;
import com.example.patshopclient.home.adapter.BidMemberAdapter;
import com.example.patshopclient.home.adapter.ProductDetailImageAdapter;
import com.example.patshopclient.home.adapter.ProductDetailBannerAdapter;
import com.example.patshopclient.home.factory.ProductDetailViewModelFactory;
import com.example.patshopclient.home.viewmodel.ProductDetailViewModel;
import com.example.patshopclient.widgets.WPTShapeTextView;
import com.example.patshopclient.widgets.WPTTimeTextView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Route(path = PathConfig.PRODUCTDETAIL)
public class ProductDetailActivity extends BaseMvvmActivity<ProductDetailViewModel> {

    public static final String PRODUCTID = "productId";
    private int productId;
    private ImageView ivBack;
    private Banner banner;
    private TextView tvProductName;
    private WPTShapeTextView btnOnlookers;
    private TextView tvOnlookers;
    private TextView tvBidNumber;
    private TextView tvCurrentPrice;
    private TextView tvMarketPrice;
    private TextView tvRemainTime;
    private WPTTimeTextView tvRemainTime1;
    private TextView tvStartPrice;
    private TextView tvHandlingFee;
    private TextView tvMarketPrice2;
    private TextView tvMarkUp;
    private TextView tvRefundRate;
    private BidMemberAdapter bidMemberAdapter;//出价成员列表adapter
    private ProductDetailBannerAdapter productDetailBannerAdapter;
    //    private RecyclerView recyclerPreviousTransactions;//历史成交价格
    private ProductDetailImageAdapter productDetailImageAdapter;//商品详情别表图adapter
    private TextView tvIncreaseBidTime;
    private TextView tvShowBidTime;
    private TextView tvDecreaseBidTime;
    private TextView btnBid;

    @Override
    public int onBindLayout() {
        return R.layout.activity_product_detail;
    }

    @Override
    public void initView() {
        ivBack = findViewById(R.id.iv_back);
        banner = findViewById(R.id.banner);
        tvProductName = findViewById(R.id.tv_product_name);
        btnOnlookers = findViewById(R.id.btn_onlookers);
        tvOnlookers = findViewById(R.id.tv_onlookers);
        tvBidNumber = findViewById(R.id.tv_bid_number);
        tvCurrentPrice = findViewById(R.id.tv_current_price);
        tvMarketPrice = findViewById(R.id.tv_market_price);
        tvRemainTime = findViewById(R.id.tv_remain_time);
        tvRemainTime1 = findViewById(R.id.tv_coun_down);
        tvStartPrice = findViewById(R.id.tv_start_Price);
        tvHandlingFee = findViewById(R.id.tv_handling_fee);
        tvMarketPrice2 = findViewById(R.id.tv_market_price2);
        tvMarkUp = findViewById(R.id.tv_markup);
        tvRefundRate = findViewById(R.id.tv_refund_rate);
        //出价成员列表
        RecyclerView rvBid = findViewById(R.id.recycler_bid);
        rvBid.setLayoutManager(new LinearLayoutManager(getContext()));
        bidMemberAdapter = new BidMemberAdapter(getContext(), null);
        View bidHead = View.inflate(getContext(), R.layout.head_bid_member, null);
        bidMemberAdapter.setHeaderView(bidHead);
        rvBid.setAdapter(bidMemberAdapter);
        productDetailBannerAdapter = new ProductDetailBannerAdapter(null);
        productDetailBannerAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
            }
        });
        banner.setAdapter(productDetailBannerAdapter);
        banner.setIndicator(new CircleIndicator(this));
        banner.setIndicatorGravity(IndicatorConfig.Direction.CENTER);
//        tvProductDetail = findViewById(R.id.tv_product_detail);
//        tvPreviousTransactions = findViewById(R.id.tv_previous_transactions);
//        tvRuleDescription = findViewById(R.id.tv_rule_description);
//        flProductDetail = findViewById(R.id.fl_product_detail);
//        flPreviousTransactions = findViewById(R.id.fl_previous_transactions);
//        flRuleDescription = findViewById(R.id.fl_rule_description);
        //    private TextView tvProductDetail;
        //    private TextView tvPreviousTransactions;
        //    private TextView tvRuleDescription;
        //    private FrameLayout flProductDetail;
        //    private FrameLayout flPreviousTransactions;
        //    private FrameLayout flRuleDescription;
        //商品详情别表
        RecyclerView recyclerProductDetail = findViewById(R.id.recycler_product_detail);
        productDetailImageAdapter = new ProductDetailImageAdapter(null);
        recyclerProductDetail.setAdapter(productDetailImageAdapter);
        recyclerProductDetail.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerPreviousTransactions = findViewById(R.id.recycler_previous_transactions);
        tvIncreaseBidTime = findViewById(R.id.tv_increase_bid_time);
        tvShowBidTime = findViewById(R.id.tv_show_bid_time);
        tvDecreaseBidTime = findViewById(R.id.tv_decrease_bid_time);
        btnBid = findViewById(R.id.btn_bid);
        SpanUtils.with(btnBid).appendLine("出价").setFontSize(18, true)
                .appendLine("0/拍币").setFontSize(12, true).create();
    }

    @Override
    public void initParam() {
        super.initParam();
        productId = getIntent().getIntExtra(PRODUCTID, 0);
        //默认选中商品详情
//        setSelect(0);
//        switchView(0);
    }

    @Override
    public void initData() {
        mViewModel.httpGetProductDetail(productId);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void initListener() {
        ivBack.setOnClickListener(v -> finish());
//        tvProductDetail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setSelect(0);
//                switchView(0);
//            }
//        });
//        tvPreviousTransactions.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setSelect(1);
//                switchView(1);
//            }
//        });
//        tvRuleDescription.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setSelect(2);
//                switchView(2);
//            }
//        });
        //增加出价次数点击事件
        tvIncreaseBidTime.setOnClickListener(v -> {
            int bidTime = Integer.parseInt(tvShowBidTime.getText().toString());
            if (bidTime >= 10) {
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("出价次数不能高于10次哦")
                        .setPositiveButton("好的👌", (dialog, which) -> dialog.dismiss()).create().show();
            } else {
                tvShowBidTime.setText((bidTime + 1) + "");
                Double bidPrice = mViewModel.bidPrice.getValue();
                bidPrice += Objects.requireNonNull(mViewModel.getProductDetailLiveEvent().getValue()).getData().getPmsProductModel().getMarkup();
                mViewModel.bidPrice.setValue(bidPrice);

            }
        });
        //减少出价次数点击事件
        tvDecreaseBidTime.setOnClickListener(v -> {
            int bidTime = Integer.parseInt(tvShowBidTime.getText().toString());
            if (bidTime <= 0) {
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("出价次数不能再小啦")
                        .setPositiveButton("好的👌", (dialog, which) -> dialog.dismiss()).create().show();
            } else {
                tvShowBidTime.setText((bidTime - 1) + "");
                Double bidPrice = mViewModel.bidPrice.getValue();
                bidPrice -= Objects.requireNonNull(mViewModel.getProductDetailLiveEvent().getValue()).getData().getPmsProductModel().getMarkup();
                mViewModel.bidPrice.setValue(bidPrice);
            }
        });
        //出价点击事件
        btnBid.setOnClickListener(v -> {
            ProductDetailDTO.DataBean.PmsProductModel productModel = Objects.requireNonNull(mViewModel.getProductDetailLiveEvent().getValue()).getData().getPmsProductModel();
            long nowDate = System.currentTimeMillis();
            long endDate = Long.parseLong(productModel.getBidCountdown());
            if (endDate < nowDate) {
                new MaterialAlertDialogBuilder(getContext()).setTitle("该商品已经街拍了哦，请查看其他拍品")
                        .setPositiveButton("确定", (dialog, which) -> dialog.cancel()).create().show();
                return;
            }
            Double bidCoin = mViewModel.bidPrice.getValue();
            String userName = UserInfoBean.getInstance().getUname();
            mViewModel.httpBidProduct(productId, bidCoin, userName);
        });
    }

    @Override
    public Class<ProductDetailViewModel> onBindViewModel() {
        return ProductDetailViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return ProductDetailViewModelFactory.getInstance(getApplication());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void initViewObservable() {
        mViewModel.getProductDetailLiveEvent().observe(this, productDetailDTO -> {
            if (ObjectUtils.isNotEmpty(productDetailDTO)) {
                ProductDetailDTO.DataBean.PmsProductModel productModel = productDetailDTO.getData().getPmsProductModel();
                //竞拍普通信息
                tvProductName.setText(productModel.getName());
                tvOnlookers.setText("围观 " + productModel.getOnlookers() + "人");
                tvBidNumber.setText("出价 " + productModel.getBids() + "人");
                mViewModel.bidPrice.setValue(productModel.getCurrentPrice());
                tvCurrentPrice.setText(" ¥" + productModel.getCurrentPrice());
                tvMarketPrice.setText("市场价\n¥ " + productModel.getMarketPrice());
                //竞拍倒计时
                tvRemainTime1.setDeadLine(Long.parseLong(productModel.getBidCountdown()));
                if (!tvRemainTime1.isRun()) {
                    tvRemainTime1.run();
                }
                tvRemainTime1.setCountRunListener((hour, min, sec) -> tvRemainTime.setText((hour < 10 ? "0" + hour : hour) + " : " + (min < 10 ? "0" + min : min) + " : " + (sec < 10 ? "0" + sec : sec)));
                tvStartPrice.setText("起拍价： " + productModel.getStartPrice() + " 拍币");
                tvHandlingFee.setText("手续费：" + productModel.getHandlingFee() + " 拍币/次");
                tvMarketPrice2.setText("市场价：" + productModel.getMarketPrice() + " 元");
                tvMarkUp.setText("加价幅度： " + productModel.getMarkup() + " 拍币");
                tvRefundRate.setText("退币比例： " + productModel.getRefundRate() + " %");
                //Banner数据源
                String[] picArray = productModel.getPic().split(",");
                List<String> picList = new ArrayList<>(Arrays.asList(picArray));
                productDetailBannerAdapter.updateData(picList);
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    banner.setIndicator(new CircleIndicator(ProductDetailActivity.this));
                    Log.d("huangqb", "dsdsd");
                }, 10000);
                //商品详情数据源
                String[] albumPics = productDetailDTO.getData().getPmsProductModel().getAlbumPics().split(",");
                List<String> detailPicList = new ArrayList<>();
                for (String albumPic : albumPics) {
                    detailPicList.add(ImageConfig.IMAGEPREFIX + albumPic);
                }
                productDetailImageAdapter.addData(detailPicList);
                //出价会员数据源
                String curPatCoin = productDetailDTO.getData().getPmsProductModel().getCurPatCoin();
                String[] curPatCoinArr = curPatCoin.split(",");
                String curPatUserNickname = productDetailDTO.getData().getPmsProductModel().getCurPatUserNickname();
                String[] curPatUserNicknameArr = curPatUserNickname.split(",");
                String curPatTime = productDetailDTO.getData().getPmsProductModel().getCurPatTime();
                String[] curPatTimeArr = curPatTime.split(",");
                String curPatUserAvatar = productDetailDTO.getData().getPmsProductModel().getCurPatUserAvatar();
                String[] curPatUserAvatarArr = curPatUserAvatar.split(",");
                String curPatUserId = productDetailDTO.getData().getPmsProductModel().getCurPatUserId();
                String[] curPatUserIdArr = curPatUserId.split(",");
                List<BidMemberPOJO> bidMemberList = new ArrayList<>();
                for (int i = 0; i < curPatCoinArr.length; i++) {
                    BidMemberPOJO bidMemberPOJO = new BidMemberPOJO();
                    bidMemberPOJO.setAvatar(curPatUserAvatarArr[i]);
                    bidMemberPOJO.setNickName(curPatUserNicknameArr[i]);
                    bidMemberPOJO.setRmb(curPatCoinArr[i]);
                    bidMemberPOJO.setPatTime(curPatTimeArr[i]);
                    bidMemberPOJO.setPosition(i);
                    bidMemberPOJO.setUserId(curPatUserIdArr[i]);
                    bidMemberList.add(bidMemberPOJO);
                }
                bidMemberAdapter.setNewData(bidMemberList);
            }
        });
        mViewModel.bidPrice.observe(this, d -> {
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            //出价价格
            SpanUtils.with(btnBid).appendLine("出价").setFontSize(18, true)
                    .appendLine(decimalFormat.format(d) + "/拍币").setFontSize(12, true).create();

        });
        mViewModel.getBidProductLiveEvent().observe(this, bidProductResultDTO -> {
            if (ObjectUtils.isEmpty(bidProductResultDTO)) {
                new MaterialAlertDialogBuilder(getContext()).setTitle("网络发生了点错误，请稍后重试")
                        .setPositiveButton("确定", (dialog, which) -> dialog.dismiss()).create().show();
            }
            if (bidProductResultDTO.getData() == 1) {
                new MaterialAlertDialogBuilder(getContext()).setTitle("拍品已截拍，谢谢您的关注")
                        .setPositiveButton("确定", (dialog, which) -> dialog.dismiss()).create().show();
            }
            if (bidProductResultDTO.getData() == -1 || bidProductResultDTO.getData() == 2) {
                new MaterialAlertDialogBuilder(getContext()).setTitle("oh no出价失败了，请稍后重试")
                        .setPositiveButton("确定", (dialog, which) -> dialog.dismiss()).create().show();
            }
            if (bidProductResultDTO.getData() == 3) {
                new MaterialAlertDialogBuilder(getContext()).setTitle("同一用户不要重复出价哦")
                        .setPositiveButton("确定", (dialog, which) -> dialog.dismiss()).create().show();
            }
            if (bidProductResultDTO.getData() == 4) {
                new MaterialAlertDialogBuilder(getContext()).setTitle("出价已低于现在最高价")
                        .setPositiveButton("确定", (dialog, which) -> dialog.dismiss()).create().show();
            }
            if (bidProductResultDTO.getData() == 0) {
                new MaterialAlertDialogBuilder(getContext()).setTitle("恭喜您，出价成功")
                        .setPositiveButton("确定", (dialog, which) -> {
                            mViewModel.httpGetProductDetail(productId);
                            dialog.dismiss();
                        }).create().show();
            }
        });
    }

//    /**
//     * type = 0 商品详情
//     * type = 1 往期成交
//     * type = 2 规则说明
//     *
//     * @param type
//     */
//    public void switchView(int type) {
//        switch (type) {
//            case 0:
//                flProductDetail.setVisibility(View.VISIBLE);
//                flPreviousTransactions.setVisibility(View.INVISIBLE);
//                flRuleDescription.setVisibility(View.INVISIBLE);
//                break;
//            case 1:
//                flProductDetail.setVisibility(View.INVISIBLE);
//                flPreviousTransactions.setVisibility(View.VISIBLE);
//                flRuleDescription.setVisibility(View.INVISIBLE);
//                break;
//            case 2:
//                flProductDetail.setVisibility(View.INVISIBLE);
//                flPreviousTransactions.setVisibility(View.INVISIBLE);
//                flRuleDescription.setVisibility(View.VISIBLE);
//                break;
//        }
//    }

//    /**
//     * type = 0 商品详情
//     * type = 1 往期成交
//     * type = 2 规则说明
//     *
//     * @param type
//     */
//    public void setSelect(int type) {
//        switch (type) {
//            case 0:
//                tvProductDetail.setSelected(true);
//                tvPreviousTransactions.setSelected(false);
//                tvRuleDescription.setSelected(false);
//                tvProductDetail.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
//                tvPreviousTransactions.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
//                tvRuleDescription.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
//                break;
//            case 1:
//                tvProductDetail.setSelected(false);
//                tvPreviousTransactions.setSelected(true);
//                tvRuleDescription.setSelected(false);
//                tvProductDetail.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
//                tvPreviousTransactions.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
//                tvRuleDescription.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
//                break;
//            case 2:
//                tvProductDetail.setSelected(false);
//                tvPreviousTransactions.setSelected(false);
//                tvRuleDescription.setSelected(true);
//                tvProductDetail.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
//                tvPreviousTransactions.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
//                tvRuleDescription.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
//                break;
//        }
//    }

}
