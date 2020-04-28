package com.example.patshopclient.home.activity;

import android.graphics.Typeface;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.example.android_patshopclient.R;
import com.example.lib_http.entity.home.ProductDetailDTO;
import com.example.patshopclient.common.mvvm.BaseMvvmActivity;
import com.example.patshopclient.common.util.image.ImageConfig;
import com.example.patshopclient.home.adapter.ProductDetailImageAdapter;
import com.example.patshopclient.home.adapter.ProductDetailBannerAdapter;
import com.example.patshopclient.home.factory.ProductDetailViewModelFactory;
import com.example.patshopclient.home.viewmodel.ProductDetailViewModel;
import com.example.patshopclient.widgets.WPTShapeTextView;
import com.example.patshopclient.widgets.WPTTimeTextView;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

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
    private RecyclerView rvBid;
    private ProductDetailBannerAdapter productDetailBannerAdapter;
    private TextView tvProductDetail;
    private TextView tvPreviousTransactions;
    private TextView tvRuleDescription;
    private FrameLayout flProductDetail;
    private FrameLayout flPreviousTransactions;
    private FrameLayout flRuleDescription;
    private RecyclerView recyclerProductDetail;
    private RecyclerView recyclerPreviousTransactions;
    private ProductDetailImageAdapter productDetailImageAdapter;
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
        rvBid = findViewById(R.id.recycler_bid);
        productDetailBannerAdapter = new ProductDetailBannerAdapter(null);
        productDetailBannerAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
            }
        });
        banner.setAdapter(productDetailBannerAdapter);
        banner.setIndicator(new CircleIndicator(this));
        banner.setIndicatorGravity(IndicatorConfig.Direction.CENTER);
        tvProductDetail = findViewById(R.id.tv_product_detail);
        tvPreviousTransactions = findViewById(R.id.tv_previous_transactions);
        tvRuleDescription = findViewById(R.id.tv_rule_description);
        flProductDetail = findViewById(R.id.fl_product_detail);
        flPreviousTransactions = findViewById(R.id.fl_previous_transactions);
        flRuleDescription = findViewById(R.id.fl_rule_description);
        recyclerProductDetail = findViewById(R.id.recycler_product_detail);
        productDetailImageAdapter = new ProductDetailImageAdapter(null);
        recyclerProductDetail.setAdapter(productDetailImageAdapter);
        recyclerProductDetail.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerPreviousTransactions = findViewById(R.id.recycler_previous_transactions);
        tvIncreaseBidTime = findViewById(R.id.tv_increase_bid_time);
        tvShowBidTime = findViewById(R.id.tv_show_bid_time);
        tvDecreaseBidTime = findViewById(R.id.tv_decrease_bid_time);
        btnBid = findViewById(R.id.btn_bid);
    }

    @Override
    public void initParam() {
        super.initParam();
        productId = getIntent().getIntExtra(PRODUCTID, 0);
        //默认选中商品详情
        setSelect(0);
        switchView(0);
    }

    @Override
    public void initData() {
        mViewModel.httpGetProductDetail(productId);
    }

    @Override
    public void initListener() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tvProductDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelect(0);
                switchView(0);
            }
        });
        tvPreviousTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelect(1);
                switchView(1);
            }
        });
        tvRuleDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelect(2);
                switchView(2);
            }
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

    @Override
    public void initViewObservable() {
        mViewModel.getProductDetailLiveEvent().observe(this, new Observer<ProductDetailDTO>() {
            @Override
            public void onChanged(ProductDetailDTO productDetailDTO) {
                if (ObjectUtils.isNotEmpty(productDetailDTO)) {
                    ProductDetailDTO.DataBean.PmsProductModel productModel = productDetailDTO.getData().getPmsProductModel();
                    tvProductName.setText(productModel.getName());
                    tvOnlookers.setText("围观 " + productModel.getOnlookers() + "人");
                    tvBidNumber.setText("出价 " + productModel.getBids() + "人");
                    tvCurrentPrice.setText(" ¥" + productModel.getCurrentPrice());
                    tvMarketPrice.setText("市场价\n¥ " + productModel.getMarketPrice());
                    tvRemainTime1.setDeadLine(TimeUtils.string2Millis(productModel.getBidCountdown()));
                    if (!tvRemainTime1.isRun()) {
                        tvRemainTime1.run();
                    }
                    tvRemainTime1.setCountRunListener(new WPTTimeTextView.TimeCountRunListener() {
                        @Override
                        public void onCountRunCallback(long hour, long min, long sec) {
                            tvRemainTime.setText((hour < 10 ? "0" + hour : hour) + " : " + (min < 10 ? "0" + min : min) + " : " + (sec < 10 ? "0" + sec : sec));
                        }
                    });
                    tvStartPrice.setText("起拍价： " + productModel.getStartPrice() + " 拍币");
                    tvHandlingFee.setText("手续费：" + productModel.getHandlingFee() + " 拍币/次");
                    tvMarketPrice2.setText("市场价：" + productModel.getMarketPrice() + " 元");
                    tvMarkUp.setText("加价幅度： " + productModel.getMarkup() + " 拍币");
                    tvRefundRate.setText("退币比例： " + productModel.getRefundRate() + " %");
                    String[] picArray = productModel.getPic().split(",");
                    List<String> picList = new ArrayList<>();
                    for (int i = 0; i < picArray.length; i++) {
                        picList.add(ImageConfig.IMAGEPREFIX + picArray[i]);
                    }
                    productDetailBannerAdapter.updateData(picList);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            banner.setIndicator(new CircleIndicator(ProductDetailActivity.this));
                            Log.d("huangqb", "dsdsd");
                        }
                    }, 10000);
                    String[] albumPics = productDetailDTO.getData().getPmsProductModel().getAlbumPics().split(",");
                    List<String> detailPicList = new ArrayList<>();
                    for (int i = 0; i < albumPics.length; i++) {
                        detailPicList.add(ImageConfig.IMAGEPREFIX + albumPics[i]);
                    }
                    productDetailImageAdapter.addData(detailPicList);
                }
            }
        });
    }

    /**
     * type = 0 商品详情
     * type = 1 往期成交
     * type = 2 规则说明
     *
     * @param type
     */
    public void switchView(int type) {
        switch (type) {
            case 0:
                flProductDetail.setVisibility(View.VISIBLE);
                flPreviousTransactions.setVisibility(View.INVISIBLE);
                flRuleDescription.setVisibility(View.INVISIBLE);
                break;
            case 1:
                flProductDetail.setVisibility(View.INVISIBLE);
                flPreviousTransactions.setVisibility(View.VISIBLE);
                flRuleDescription.setVisibility(View.INVISIBLE);
                break;
            case 2:
                flProductDetail.setVisibility(View.INVISIBLE);
                flPreviousTransactions.setVisibility(View.INVISIBLE);
                flRuleDescription.setVisibility(View.VISIBLE);
                break;
        }
    }

    /**
     * type = 0 商品详情
     * type = 1 往期成交
     * type = 2 规则说明
     *
     * @param type
     */
    public void setSelect(int type) {
        switch (type) {
            case 0:
                tvProductDetail.setSelected(true);
                tvPreviousTransactions.setSelected(false);
                tvRuleDescription.setSelected(false);
                tvProductDetail.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                tvPreviousTransactions.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                tvRuleDescription.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                break;
            case 1:
                tvProductDetail.setSelected(false);
                tvPreviousTransactions.setSelected(true);
                tvRuleDescription.setSelected(false);
                tvProductDetail.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                tvPreviousTransactions.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                tvRuleDescription.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                break;
            case 2:
                tvProductDetail.setSelected(false);
                tvPreviousTransactions.setSelected(false);
                tvRuleDescription.setSelected(true);
                tvProductDetail.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                tvPreviousTransactions.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                tvRuleDescription.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                break;
        }
    }

}
