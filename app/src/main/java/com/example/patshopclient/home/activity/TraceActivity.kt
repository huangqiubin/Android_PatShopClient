package com.example.patshopclient.home.activity

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.android_patshopclient.R
import com.example.patshopclient.common.config.PathConfig
import com.example.patshopclient.common.mvvm.BaseMvvmActivity
import com.example.patshopclient.home.factory.MainViewModelFactory
import com.example.patshopclient.home.viewmodel.MineViewModel
import kotlinx.android.synthetic.main.common_toolbar.*

@Route(path = PathConfig.TRACEFOOT)
class TraceActivity : BaseMvvmActivity<MineViewModel>() {

    override fun onBindLayout(): Int {
        return R.layout.activity_trace
    }

    override fun initView() {
        toolbar_title.visibility = View.VISIBLE
        toolbar_title.text = "足迹"
        iv_back.visibility = View.VISIBLE
    }

    override fun initData() {
    }

    override fun initListener() {
        super.initListener()
        iv_back.setOnClickListener {
            finish()
        }
    }

    override fun onBindViewModel(): Class<MineViewModel> {
        return MineViewModel::class.java
    }

    override fun onBindViewModelFactory(): ViewModelProvider.Factory {
        return MainViewModelFactory.getInstance(application)
    }

    override fun initViewObservable() {
    }


}
