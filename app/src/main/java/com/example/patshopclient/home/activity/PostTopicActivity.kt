package com.example.patshopclient.home.activity

import android.content.DialogInterface
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.LogUtils
import com.example.android_patshopclient.R
import com.example.lib_http.pojo.TopicPOJO
import com.example.lib_http.entity.home.TopicListDTO
import com.example.patshopclient.common.mvvm.BaseMvvmActivity
import com.example.patshopclient.home.adapter.TopicAlbumAdapter
import com.example.patshopclient.home.factory.CommunityViewModelFactory
import com.example.patshopclient.home.model.TopicAlbumModel
import com.example.patshopclient.home.viewmodel.CommunityViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_post_topic.*
import kotlinx.android.synthetic.main.common_toolbar.*

class PostTopicActivity : BaseMvvmActivity<CommunityViewModel>() {

    private var topicSecTypeList = mutableListOf<TopicListDTO.DataBean.HotTopicListBean>()
    private var topicAlbumList = mutableListOf<TopicAlbumModel>()
    private var topicAlbumAdapter = TopicAlbumAdapter(topicAlbumList)
    private var topicTypeList = arrayListOf("游戏点卷", "手机数码", "美妆好物", "生活百货")
    private var topicDTO = TopicPOJO()

    override fun onBindLayout(): Int {
        return R.layout.activity_post_topic
    }

    override fun initView() {
        var topicAlbumModel = TopicAlbumModel()
        topicAlbumModel.type = 1
        topicAlbumAdapter.addData(topicAlbumModel)
        recycler_view.adapter = topicAlbumAdapter
        iv_back.visibility = View.VISIBLE
    }

    override fun initListener() {
        super.initListener()
        ll_topic_sec_type.setOnClickListener {
            if (topicSecTypeList.isNullOrEmpty()) return@setOnClickListener
            var topicArray = topicSecTypeList.map { it.secTopicName }
            MaterialAlertDialogBuilder(context)
                    .setTitle("选择话题")
                    .setSingleChoiceItems(topicArray.toTypedArray(), 0) { dialogInterface: DialogInterface, i: Int ->
                        tv_select_topic_sec_type.text = topicArray[i]
                        tv_select_topic_sec_type.visibility = View.VISIBLE
                        dialogInterface.dismiss()
                    }.create().show()
        }

        ll_topic_type.setOnClickListener {
            MaterialAlertDialogBuilder(context)
                    .setTitle("话题分类")
                    .setSingleChoiceItems(topicTypeList.toTypedArray(), 0) { dialogInterface: DialogInterface, i: Int ->
                        tv_select_topic_type.text = topicTypeList[i]
                        tv_select_topic_type.visibility = View.VISIBLE
                        dialogInterface.dismiss()
                    }.create().show()
        }

        topicAlbumAdapter.setOnItemClickListener { adapter, view, position ->
            when (view.id) {
                R.id.ll_album -> LogUtils.dTag("huangqiubin", "iamge点击事件")
            }
        }

        iv_back.setOnClickListener {
            finish()
        }

        btn_complete.setOnClickListener {
            if (!checkData()) return@setOnClickListener
            topicDTO.topicType = tv_select_topic_type.text.toString()
            topicDTO.topicSecType = tv_select_topic_sec_type.text.toString()
            topicDTO.topicContent = et_content.text.toString()
            mViewModel.UIChangeLiveData().showTransLoadingViewEvent.postValue(true)
            mViewModel.httpPostTopic(topicDTO)


        }

    }

    override fun initData() {
        mViewModel.httpGetTopicList()
    }

    override fun onBindViewModel(): Class<CommunityViewModel> {
        return CommunityViewModel::class.java
    }

    override fun onBindViewModelFactory(): ViewModelProvider.Factory {
        return CommunityViewModelFactory.getInstance(application)
    }

    override fun initViewObservable() {
        mViewModel.topicListLiveEvent.observe(this, Observer {
            if (it == null) return@Observer
            topicSecTypeList = it.data.hotTopicList
        })

        mViewModel.responceLiveEvent.observe(this, Observer {
            if (it == null || it.code != 200) return@Observer
            if (it.data == 1) {
                Toast.makeText(context, "话题发布成功！", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                MaterialAlertDialogBuilder(context)
                        .setTitle("网络出现了点小异常，请稍后重试")
                        .setPositiveButton("确定") { dialog, which ->
                            dialog.cancel()
                        }
                        .show()
            }
        })

    }

    private fun checkData(): Boolean {
        if (tv_select_topic_type.text.isNullOrBlank()) {
            Toast.makeText(context, "话题分类不能为空哦", Toast.LENGTH_SHORT).show()
            return false
        }
        if (tv_select_topic_sec_type.text.isNullOrBlank()) {
            Toast.makeText(context, "记得参与话题哦", Toast.LENGTH_SHORT).show()
            return false
        }
        if (et_content.text.isNullOrBlank()) {
            Toast.makeText(context, "话题内容是不是忘填了呢", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
