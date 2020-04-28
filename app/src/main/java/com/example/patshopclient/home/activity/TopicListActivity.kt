package com.example.patshopclient.home.activity

import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.android_patshopclient.R
import com.example.patshopclient.common.mvvm.BaseMvvmActivity
import com.example.patshopclient.home.adapter.TopicListAdapter
import com.example.patshopclient.home.factory.CommunityViewModelFactory
import com.example.patshopclient.home.viewmodel.CommunityViewModel
import kotlinx.android.synthetic.main.activity_topic_list.*

/**
 * 话题热搜榜
 */
@Route(path = "/community/hot_topic_list")
class TopicListActivity : BaseMvvmActivity<CommunityViewModel>() {

    lateinit var topicListAdapter: TopicListAdapter


    override fun onBindLayout(): Int {
        return R.layout.activity_topic_list
    }

    override fun initView() {
        recycler_topic.layoutManager = LinearLayoutManager(context)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        collapsing_toolbar.title = "热门话题榜"
        topicListAdapter = TopicListAdapter(R.layout.item_topic_list, null)
        topicListAdapter.setEmptyView(View.inflate(context, R.layout.view_no_data, null))
        recycler_topic.adapter = topicListAdapter
        topicListAdapter.setHeaderView(View.inflate(context, R.layout.head_ugc_topic_rank, null))
    }

    override fun initData() {
        mViewModel.httpGetTopicList()
    }

    override fun initListener() {
        super.initListener()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBindViewModel(): Class<CommunityViewModel> {
        return CommunityViewModel::class.java
    }

    override fun onBindViewModelFactory(): ViewModelProvider.Factory {
        return CommunityViewModelFactory.getInstance(application)
    }

    override fun initViewObservable() {
        mViewModel.topicListLiveEvent.observe(this, Observer {
            if (it.data.hotTopicList == null) {
                return@Observer
            }
            topicListAdapter.setNewData(it.data.hotTopicList)
        })
    }

}
