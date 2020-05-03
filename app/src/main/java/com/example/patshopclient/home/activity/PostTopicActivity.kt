package com.example.patshopclient.home.activity

import android.content.DialogInterface
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.LogUtils
import com.example.android_patshopclient.R
import com.example.lib_http.entity.home.TopicListDTO
import com.example.lib_http.pojo.TopicPOJO
import com.example.patshopclient.common.mvvm.BaseMvvmActivity
import com.example.patshopclient.common.pictureselector.GlideEngine
import com.example.patshopclient.home.POJO.TopicAlbumPOJO
import com.example.patshopclient.home.adapter.TopicAlbumAdapter
import com.example.patshopclient.home.factory.CommunityViewModelFactory
import com.example.patshopclient.home.viewmodel.CommunityViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import kotlinx.android.synthetic.main.activity_post_topic.*
import kotlinx.android.synthetic.main.common_toolbar.*
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File


class PostTopicActivity : BaseMvvmActivity<CommunityViewModel>() {

    private var topicSecTypeList = mutableListOf<TopicListDTO.DataBean.HotTopicListBean>()
    private var topicAlbumList = mutableListOf<TopicAlbumPOJO>()
    private var topicAlbumAdapter = TopicAlbumAdapter(topicAlbumList)
    private var topicTypeList = arrayListOf("游戏点卷", "手机数码", "美妆好物", "生活百货")
    private var topicDTO = TopicPOJO()

    override fun onBindLayout(): Int {
        return R.layout.activity_post_topic
    }

    override fun initView() {
        var topicAlbumModel = TopicAlbumPOJO()
        topicAlbumModel.type = 1
        topicAlbumAdapter.addData(topicAlbumModel)
        recycler_view.adapter = topicAlbumAdapter
        iv_back.visibility = View.VISIBLE
    }

    override fun initListener() {
        super.initListener()
        topicAlbumAdapter.addChildClickViewIds(R.id.ll_album, R.id.iv_close)
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

        iv_back.setOnClickListener {
            finish()
        }

        //发布话题
        btn_complete.setOnClickListener {
            if (!checkData()) return@setOnClickListener
            topicDTO.topicType = tv_select_topic_type.text.toString()
            topicDTO.topicSecType = tv_select_topic_sec_type.text.toString()
            topicDTO.topicContent = et_content.text.toString()
            mViewModel.UIChangeLiveData().showTransLoadingViewEvent.postValue(true)
            var files = mutableListOf<MultipartBody.Part>()
            val imagePaths = mViewModel.imagePath.value
            if (imagePaths != null) {
                for (path in imagePaths) {
                    var imageFile = File(path)
                    var requestBody = imageFile.asRequestBody("application/json".toMediaTypeOrNull())
                    var imagePart = MultipartBody.Part.createFormData("files", imageFile.name, requestBody)
                    files.add(imagePart)
                }
            }
            mViewModel.httpPostTopic(topicDTO, files)
        }

        topicAlbumAdapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                R.id.ll_album -> {
                    PictureSelector.create(this)
                            .openGallery(PictureMimeType.ofImage())
                            .loadImageEngine(GlideEngine.createGlideEngine()) // 请参考Demo GlideEngine.java
                            .forResult(object : OnResultCallbackListener<LocalMedia> {
                                override fun onResult(result: MutableList<LocalMedia>?) {
                                    Log.d("huangqiubin", "成功选择照片!")
                                    var imageList = mutableListOf<String>()
                                    if (result != null) {
                                        for (localmedia in result) {
                                            imageList.add(localmedia.path)
                                        }
                                    }
                                    var imagePathList = mutableListOf<String>()
                                    imagePathList.addAll(imageList)
                                    mViewModel.imagePath.value?.let { imagePathList.addAll(it) }
                                    mViewModel.imagePath.value = imagePathList
                                }

                                override fun onCancel() {
                                    Log.d("huangqiubin", "取消选择照片!")
                                }

                            })
                }
                R.id.iv_close -> {
                    var imageList = mViewModel.imagePath.value
                    imageList?.removeAt(position)
                    mViewModel.imagePath.postValue(imageList)
                }
            }

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
        //参与话题
        mViewModel.topicListLiveEvent.observe(this, Observer {
            if (it == null) return@Observer
            topicSecTypeList = it.data.hotTopicList
        })
        //发布结果话题
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
        //选择话题图片
        mViewModel.imagePath.observe(this, Observer {
            var topicAlbumList = mutableListOf<TopicAlbumPOJO>()
            for (topicAlbum in it) {
                var albumPOJO = TopicAlbumPOJO()
                albumPOJO.type = 0
                albumPOJO.imgPath = topicAlbum
                topicAlbumList.add(albumPOJO)
            }
            var topicSpec = TopicAlbumPOJO()
            topicSpec.type = 1
            topicAlbumList.add(topicSpec)
            topicAlbumAdapter.setNewData(topicAlbumList)
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
