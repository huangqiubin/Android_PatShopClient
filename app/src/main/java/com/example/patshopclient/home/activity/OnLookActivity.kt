package com.example.patshopclient.home.activity

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.example.android_patshopclient.R
import com.example.lib_http.entity.home.OnLookListDTO
import com.example.lib_userinfo.config.UserInfoBean
import com.example.patshopclient.common.baseview.NoDataView
import com.example.patshopclient.common.config.PathConfig
import com.example.patshopclient.common.mvvm.BaseMvvmActivity
import com.example.patshopclient.home.adapter.OnLookAdapter
import com.example.patshopclient.home.factory.MainViewModelFactory
import com.example.patshopclient.home.viewmodel.MineViewModel
import kotlinx.android.synthetic.main.activity_on_look.*
import kotlinx.android.synthetic.main.common_toolbar.*

@Route(path = PathConfig.ONLOOK)
class OnLookActivity : BaseMvvmActivity<MineViewModel>() {

    private var onLookAdapter = OnLookAdapter(null)

    override fun onBindLayout(): Int {
        return R.layout.activity_on_look
    }

    override fun initView() {
        toolbar_title.visibility = View.VISIBLE
        toolbar_title.text = "围观"
        iv_back.visibility = View.VISIBLE
        recycler.layoutManager = GridLayoutManager(context, 2)
        onLookAdapter.setEmptyView(NoDataView(context, null))
        recycler.adapter = onLookAdapter
    }

    override fun initData() {
        var userName = UserInfoBean.getInstance().uname
        mViewModel.getOnLookList(userName)
    }

    override fun initListener() {
        super.initListener()
        iv_back.setOnClickListener {
            finish()
        }

        onLookAdapter.setOnItemClickListener(OnItemClickListener { adapter, view, position ->
            var onLookDTO = adapter.data[position] as OnLookListDTO.DataBean.OnLookListBean
            ARouter.getInstance().build(PathConfig.PRODUCTDETAIL).withInt(ProductDetailActivity.PRODUCTID, onLookDTO.productId).navigation()
        })
    }

    override fun onBindViewModel(): Class<MineViewModel> {
        return MineViewModel::class.java
    }

    override fun onBindViewModelFactory(): ViewModelProvider.Factory {
        return MainViewModelFactory.getInstance(application)
    }

    override fun initViewObservable() {
        mViewModel.onLookListLiveEvent.observe(this, Observer {
            if (it.data.onLookList.isNullOrEmpty()) {
                return@Observer
            }
            onLookAdapter.setNewData(it.data.onLookList)
        })
    }

}
