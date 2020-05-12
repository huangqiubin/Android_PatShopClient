package com.example.patshopclient.home.activity

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.android_patshopclient.R
import com.example.lib_http.entity.home.BidSaleDTO
import com.example.lib_userinfo.config.UserInfoBean
import com.example.patshopclient.common.baseview.NoDataView
import com.example.patshopclient.common.config.PathConfig
import com.example.patshopclient.common.mvvm.BaseMvvmActivity
import com.example.patshopclient.home.adapter.BidSaleAdapter
import com.example.patshopclient.home.factory.MainViewModelFactory
import com.example.patshopclient.home.viewmodel.MineViewModel
import kotlinx.android.synthetic.main.activity_bid_sale.*
import kotlinx.android.synthetic.main.common_toolbar.*

@Route(path = PathConfig.BIDSALE)
class BidSaleActivity : BaseMvvmActivity<MineViewModel>() {

    private var bidSaleAdapter = BidSaleAdapter(null)

    override fun onBindLayout(): Int {
        return R.layout.activity_bid_sale
    }

    override fun initView() {
        toolbar_title.visibility = View.VISIBLE
        toolbar_title.text = "参拍"
        iv_back.visibility = View.VISIBLE
        bidSaleAdapter.setEmptyView(NoDataView(context, null))
        recycler_view.layoutManager = GridLayoutManager(context, 2)
        recycler_view.adapter = bidSaleAdapter
    }

    override fun initData() {
        var userName = UserInfoBean.getInstance().uname
        mViewModel.getBidSaleList(userName)
    }

    override fun initListener() {
        super.initListener()
        iv_back.setOnClickListener {
            finish()
        }

        bidSaleAdapter.setOnItemClickListener { adapter, view, position ->
            var bidResultModelListBean = adapter.data[position] as BidSaleDTO.DataBean.BidResultListBean
            var productId = bidResultModelListBean.productId
            ARouter.getInstance().build(PathConfig.PRODUCTDETAIL).withInt(ProductDetailActivity.PRODUCTID, productId).navigation()
            Log.d("huangqiubin","bidSaleActivity click")
        }
    }


    override fun onBindViewModel(): Class<MineViewModel> {
        return MineViewModel::class.java
    }

    override fun onBindViewModelFactory(): ViewModelProvider.Factory {
        return MainViewModelFactory.getInstance(application)
    }

    override fun initViewObservable() {
        mViewModel.bidSaleListLiveEvent.observe(this, Observer {
            if (it.data.bidResultList.isNullOrEmpty()) {
                return@Observer
            }
            bidSaleAdapter.setNewData(it.data.bidResultList)
        })
    }
}
