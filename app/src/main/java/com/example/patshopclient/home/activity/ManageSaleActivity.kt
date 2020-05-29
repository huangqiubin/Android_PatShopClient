package com.example.patshopclient.home.activity

import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.android_patshopclient.R
import com.example.patshopclient.common.config.PathConfig
import com.example.patshopclient.common.mvvm.BaseMvvmActivity
import com.example.patshopclient.home.adapter.ManageViewPagerAdapter
import com.example.patshopclient.home.factory.ManageSaleViewModelFactory
import com.example.patshopclient.home.fragment.ManageSaleFragment
import com.example.patshopclient.home.viewmodel.ManageSaleViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.common_toolbar.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.toolbar_title

@Route(path = PathConfig.MANAGESALE)
class ManageSaleActivity() : BaseMvvmActivity<ManageSaleViewModel>() {

    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout
    lateinit var rlAddProduct: RelativeLayout
    var fragmentList = mutableListOf<Fragment>()
    var titleList = mutableListOf<String>("竞拍中", "已下架")
    private var manageViewPagerAdapter: ManageViewPagerAdapter = ManageViewPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
            fragmentList, titleList)

    override fun onBindLayout(): Int {
        return R.layout.activity_manage_sale
    }

    override fun initView() {
        toolbar_title.visibility = View.VISIBLE
        toolbar_title.text = "商品管理"
        iv_back.visibility = View.VISIBLE
        viewPager = findViewById(R.id.viewpager)
        viewpager.adapter = manageViewPagerAdapter
        tabLayout = findViewById(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)
        rlAddProduct = findViewById(R.id.rl_add_product)
        for (s in titleList) {
            var manageSaleFragment = ManageSaleFragment()
            var bundle = Bundle()
            bundle.putString("title", s)
            manageSaleFragment.arguments = bundle
            fragmentList.add(manageSaleFragment)
        }
        manageViewPagerAdapter.notifyDataSetChanged()
    }

    override fun initData() {

    }

    override fun initListener() {
        super.initListener()
        iv_back.setOnClickListener {
            finish()
        }

        rlAddProduct.setOnClickListener{
            ARouter.getInstance().build(PathConfig.ADDPRODUCT).navigation()
        }
    }

    override fun onBindViewModel(): Class<ManageSaleViewModel> {
        return ManageSaleViewModel::class.java
    }

    override fun onBindViewModelFactory(): ViewModelProvider.Factory {
        return ManageSaleViewModelFactory.getInstance(application)
    }

    override fun initViewObservable() {

    }

}

